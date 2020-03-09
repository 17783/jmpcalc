package com.example.jmp.calc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException, BadFormatException {

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput = reader.readLine();
        try {
            Parser.checkInputValidity(consoleInput);
        } catch (BadFormatException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        boolean roman = Parser.isRoman(consoleInput);
        System.out.println("using roman numerals: " + roman);
        String element0 = Parser.getElements(consoleInput)[0];
        String element1 = Parser.getElements(consoleInput)[1];
        String operator = Parser.getOperator(consoleInput);
        if (roman) {
            try {
                Parser.checkElementSize(Integer.toString(Parser.getArabic(element0)), Integer.toString(Parser.getArabic(element0)));
            } catch (BadFormatException ex)
            {
                System.out.println(ex.getMessage());
                System.exit(1);
            }
        } else {
            try {
                Parser.checkElementSize(element0, element1);
            } catch (BadFormatException ex)
            {
                System.out.println(ex.getMessage());
                System.exit(1);
            }
        }

    Computer.getResult(element0, element1, operator, roman);

    }
}
