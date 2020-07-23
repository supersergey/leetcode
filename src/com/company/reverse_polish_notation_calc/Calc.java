package com.company.reverse_polish_notation_calc;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Calc {
    private final static String DIVIDER = " ";
    private final static String MULTIPLY = "*";
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String DIVIDE = "/";
    private final static Set<String> OPERATORS = new HashSet<>(Arrays.asList(DIVIDE, MINUS, PLUS, MULTIPLY));

    public double evaluate(String expr) {
        final String[] elements = expr.split(DIVIDER);
        final Deque<String> deque = new LinkedList<>();
        for (String e : elements) {
            if (!OPERATORS.contains(e)) {
                deque.push(e);
            } else {
                double v1 = Double.parseDouble(deque.pop());
                double v2 = Double.parseDouble(deque.pop());
                deque.push(calculate(v1, v2, e));
            }
        }
        return Double.parseDouble(deque.pop());
    }

  private String calculate(double v1, double v2, String operator) {
    switch (operator) {
        case MULTIPLY:
            return Double.toString(v1 * v2);
        case PLUS:
            return Double.toString(v1 + v2);
        case MINUS:
            return Double.toString(v2 - v1);
        case DIVIDE:
            return Double.toString(v2 / v1);
      default:
        throw new IllegalArgumentException("Unable to evaluate expression, unknown operator: " + operator);
    }
  }
}