package com.company.number_of_ordinal;

class Challenge {
    public static String numberToOrdinal(Integer number) {
        if (number == null)
            return null;
        if (number == 0)
            return "0";
        if (number < 0)
          throw new IllegalArgumentException("Unable handle the input number");
        int remaining = number % 100;
        if (remaining >= 10 && remaining <= 20)
          return number + "th";
        remaining = number % 10;
        switch (remaining) {
            case 1: return number + "st";
            case 2: return number + "nd";
            case 3: return number + "rd";
            default: return number + "th";
        }
    }
}