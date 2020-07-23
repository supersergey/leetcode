package com.company.print_zero_even_odd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private final Lock lock = new ReentrantLock();

    private final Condition zeroCondition = lock.newCondition();

    private final Condition evenCondition = lock.newCondition();

    private final Condition oddCondition = lock.newCondition();

    private int lastPrinted = 1;

    private int beforePrinted;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (lastPrinted == 0) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                lastPrinted = 0;
                if (beforePrinted % 2 != 0) {
                    evenCondition.signal();
                } else {
                    oddCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            lock.lock();
            try {
                while (lastPrinted != 0 || beforePrinted % 2 == 0) {
                    evenCondition.await();
                }
                beforePrinted = i;
                lastPrinted = i;
                printNumber.accept(i);

                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            lock.lock();
            try {
                while (lastPrinted != 0 || beforePrinted % 2 != 0) {
                    oddCondition.await();
                }
                beforePrinted = i;
                lastPrinted = i;
                printNumber.accept(i);

                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}