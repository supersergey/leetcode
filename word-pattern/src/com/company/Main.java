package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (words.length != pattern.length() || pattern.length() == 0)
            return false;
        else
        try {
            for (int i = 0; i < pattern.length(); i++) {
                List<Integer> patternPositions = new LinkedList<>();
                patternPositions.add(i);
                char currentPatternElement = pattern.charAt(i);
                int nextPatternElement = 0;
                while ((nextPatternElement < pattern.length()) && (nextPatternElement != -1)) {
                    nextPatternElement = pattern.indexOf(currentPatternElement, nextPatternElement);
                    if (nextPatternElement != -1)
                    {
                        patternPositions.add(nextPatternElement);
                        nextPatternElement++;
                    }
                }
                String currentWord = words[i];
                for (Integer x : patternPositions)
                    if (!currentWord.equals(words[x]))
                        throw new IOException();
                for (int j = 0; j < pattern.length(); j++)
                    if (!patternPositions.contains(j))
                        if (currentWord.equals(words[j]))
                            throw new IOException();
            }
            return true;
        }
        catch (IOException ex)
        {
            return false;
        }


    }
}
