package com.company.brackets_match;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
  
  static int bracketMatch(String text) {
    if(text == null || text.length() == 0) {
      return 0;
    }
    int result = 0;
    Deque<Character> deque = new LinkedList<>();
    for(char c : text.toCharArray()) {
      if(c == '(')
        deque.push(c);
      if(c == ')' && !deque.isEmpty()) {
        deque.pop();
      } else if(c == ')') {
        result++;
      }
    }
    return result + deque.size();
  }

  public static void main(String[] args) {
    System.out.println(Solution.bracketMatch("("));
    System.out.println(Solution.bracketMatch("(()"));
    System.out.println(Solution.bracketMatch("(())"));
    System.out.println(Solution.bracketMatch("())("));
    System.out.println(Solution.bracketMatch("(())"));
  }

}