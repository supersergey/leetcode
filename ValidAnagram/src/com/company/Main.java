package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Main main = new Main();
        String s = "rat";
        String t = "car";
        System.out.println(main.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        char[] sch  = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        return Arrays.equals(sch, tch);
    }
}
