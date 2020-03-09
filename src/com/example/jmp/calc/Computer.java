package com.example.jmp.calc;

public class Computer {
    public static int compute(int x, int y, String operator) {
        int result = 0;
        switch (operator) {
            case "/":
                if (y == 0) {
                    System.out.println("DIVISION BY ZERO");
                    result = 0;
                    break;
                } else {
                    result = x / y;
                }
                break;
            case "*":
                result = x * y;
                break;
            case "-":
                result = x - y;
                break;
            case "+":
                result = x + y;
                break;
            default:
                System.out.println("Error: operation does not exist");
                result = 0;
                break;
        }
        return result;
    }

    public static String getResult(String element0, String element1, String operator, boolean roman) throws BadFormatException {
        int element0Int;
        int element1Int;
        int result = 0;
        String finalResult;
        if (!roman) {
            element0Int = Integer.parseInt(element0);
            element1Int = Integer.parseInt(element1);
            result = Computer.compute(element0Int, element1Int, operator);
            finalResult = Integer.toString(result);

        } else {
            element0Int = Parser.getArabic(element0);
            element1Int = Parser.getArabic(element1);
            result = Computer.compute(element0Int, element1Int, operator);
            finalResult = Parser.getRoman(result);
        }

        System.out.println(element0.toUpperCase() + " " + operator + " " + element1.toUpperCase() + " = " + finalResult);
        return finalResult;
    }
}
