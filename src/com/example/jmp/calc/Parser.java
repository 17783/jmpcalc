package com.example.jmp.calc;

import java.util.Arrays;

public class Parser {
    public static final int[] ARABIC = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final String[] ROMAN = {"i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x"};
    public static final String ELEMENT_DELIMITERS = "[+\\-*/ ]+";
    public static final String OPERATOR_DELIMITERS = "[IVXivx\\d\\s]+";
    public static final String ROMAN_CHECK = "[IVXivx+\\-*\\/ ]+";

    public static String[] getElements(String input) {
        return input.split(ELEMENT_DELIMITERS);
    }

    public static String getOperator(String input) {
        return input.split(OPERATOR_DELIMITERS)[1];
    }

    public static boolean isRoman(String input) {
        return input.matches(ROMAN_CHECK);
    }

    public static boolean checkInputValidity(String input) {
        boolean globalMatch = input.matches("[IVXivx\\d\\s]+[+\\-*\\/][IVXivx\\d\\s]+");
        boolean romanMatch = input.matches("[IVXivx\\s]+[+\\-*\\/][IVXivx\\s]+");
        boolean arabicMatch = input.matches("[\\d\\s]+[+\\-*\\/][\\d\\s]+");
        return (globalMatch && romanMatch) || (globalMatch && arabicMatch);

    }

    public static void checkElementSize(String element0, String element1) {
//        if (Parser.getArabic(element0))
        if (Integer.parseInt(element0) < 0 || Integer.parseInt(element0) > 10) {
            System.out.println("first value is too big, only 0..10 values are accepted");
            System.exit(1);
        } else if (Integer.parseInt(element1) < 0 || Integer.parseInt(element1) > 10) {
            System.out.println("second value is too big, only 0..10 values are accepted");
            System.exit(1);
        }
    }

    public static int getArabic(String element) {
        element = element.toLowerCase();
        int index = Arrays.binarySearch(ROMAN, element);
//        index = (index < 0) ? -1 : index;
        if (index < 0) {
            System.out.println("value of \"" + element + "\" is out of bounds, only roman values from I to X are accepted");
            System.exit(1);
        }
        int result = 0;
        result = ARABIC[index];
        return result;
    }

    public static String getRoman(int number) {
        if (number == 0) {
            return String.valueOf(0);
        }
        String[] romanLarge = {"M", "XM", "CM", "D", "XD", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(romanLarge[i]);
            }
            i++;
        }
        return result.toString();
    }
}
