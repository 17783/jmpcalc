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

    //check if using roman numerals
    public static boolean isRoman(String input) {
        return input.matches(ROMAN_CHECK);
    }

    public static void checkInputValidity(String input) throws BadFormatException {
        // global format check
        /*
            Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
            Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числа.
            Калькулятор умеет работать только с целыми числами.
         */
        if (!input.matches("[IVXivx\\d\\s]+[+\\-*\\/][IVXivx\\d\\s]+")) {
            throw new BadFormatException("bad format, only integers from 1 to 10, roman numerals from I to X and '+','-','/','*' operators are allowed");
        }
        /*
        Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
         */
        boolean romanMatch = input.matches("[IVXivx\\s]+[+\\-*\\/][IVXivx\\s]+");
        boolean arabicMatch = input.matches("[\\d\\s]+[+\\-*\\/][\\d\\s]+");
        if (!(romanMatch || arabicMatch)) {
            throw new BadFormatException("mixed roman and arabic input is NOT allowed");
        }

    }

    /*
        Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.a
     */
    public static void checkElementSize(String element0, String element1) throws BadFormatException {
        if (Integer.parseInt(element0) < 1 || Integer.parseInt(element0) > 10) {
            throw new BadFormatException("value " + element0 + " is of bounds, only 1..10 values are allowed");
        } else if (Integer.parseInt(element1) < 1 || Integer.parseInt(element1) > 10) {
            throw new BadFormatException("value " + element1 + " is of bounds, only 1..10 values are allowed");
        }
    }

    public static int getArabic(String element) throws BadFormatException {
        element = element.toLowerCase();
        int index = Arrays.binarySearch(ROMAN, element);
        if (index < 0) {
            throw new BadFormatException("value of \"" + element + "\" is out of bounds, only roman values from I to X are allowed");
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
