package com.company.mask_credit_card;

class CreditCard {

    private final static char MASK = '#';

    private final static int MIN_LENGTH = 6;

    private final static int END_OFFSET = 4;

    public static String maskify(String creditCardNumber) {
        if (isNotEligibleForMasking(creditCardNumber, MIN_LENGTH))
            return creditCardNumber;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < creditCardNumber.length(); i++) {
            if (Character.isDigit(creditCardNumber.charAt(i)) &&
                    isInMaskedRange(i, 1, creditCardNumber.length() - END_OFFSET)
            )
                sb.append(MASK);
            else
                sb.append(creditCardNumber.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isNotEligibleForMasking(String s, int minLength) {
        return s == null || s.length() < minLength;
    }

    private static boolean isInMaskedRange(int i, int offsetStart, int offsetEnd) {
        return i >= offsetStart && i < offsetEnd;
    }

    public static void main(String[] args) {
        System.out.println(CreditCard.maskify("4556364607935616"));
        System.out.println(CreditCard.maskify("4556-3646-0793-5616"));
        System.out.println(CreditCard.maskify("64607935616"));
        System.out.println(CreditCard.maskify("ABCD-EFGH-IJKLM-NOPQ"));
        System.out.println(CreditCard.maskify("A1234567BCDEFG89HI"));
        System.out.println(CreditCard.maskify("12345"));
        System.out.println(CreditCard.maskify(""));
        System.out.println(CreditCard.maskify("Skippy"));
        System.out.println(CreditCard.maskify(null));
    }
}

