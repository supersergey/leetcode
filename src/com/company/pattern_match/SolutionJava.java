package com.company.pattern_match;

class SolutionJava {

    // https://leetcode.com/problems/regular-expression-matching/

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p);
            }
            return false;
        } else {                                     // second char is not '*'
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SolutionJava s = new SolutionJava();
        assert(!s.isMatch("mississippi", "mis*is*p*."));
        assert (s.isMatch("a", "ab*"));
        assert (s.isMatch("aaa", "a*a"));
        assert (s.isMatch("abc", "a.*"));
        assert (s.isMatch("aa", "a*"));
        assert (s.isMatch("aa", "aa"));
        assert (s.isMatch("abc", "a.c"));
        assert (s.isMatch("abbb", "ab*"));
        assert (s.isMatch("acd", "ab*c."));
        assert (s.isMatch("abaa", "a.*a*"));
        assert (!s.isMatch("aa", "a"));
        assert (s.isMatch("acd", "ab*c."));
        assert (s.isMatch("aab", "c*a*b"));
    }
}
