package com.example.jmp.calc;

import java.util.Arrays;

public class Parser {
    private static int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static String[] roman = {"i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x"};

    public static int getArabic(String element) {
        element = element.toLowerCase();
        int index = Arrays.binarySearch(roman, element);
        index = (index < 0) ? -1 : index;
        int result = 0;
        result = arabic[index];
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
