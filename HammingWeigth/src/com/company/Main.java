package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(hammingWeight(3));
    }

    public static int hammingWeight(int n) {

        String s = Integer.toBinaryString(n);
        int counter = 0;
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i)=='1')
                counter++;
        return counter;

    }
}
