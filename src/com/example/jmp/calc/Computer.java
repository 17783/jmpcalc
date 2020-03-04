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
}
