package com.example.jmp.calc;

public class Input {
    public static boolean checkInputValidity(String input) {
        return input.matches("[IVXivx\\d\\s]+[+\\-*\\/][IVXivx\\d\\s]+");
    }

    public static void checkElementSize(String element0, String element1) {
//        if (Parser.getArabic(element0))
        if (Integer.parseInt(element0) <0 || Integer.parseInt(element0)>10) {
            System.out.println("first value is too big, only 0..10 values are accepted");
            System.exit(1);
        } else if (Integer.parseInt(element1) <0 || Integer.parseInt(element1)>10) {
            System.out.println("second value is too big, only 0..10 values are accepted");
            System.exit(1);
        }
    }
}
