package com.example.jmp.calc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException, BadFormatException {

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        try {
            Parser.checkInputValidity(name);
//            System.out.println("bad format, only integers from 1 to 10, roman numerals from I to X and '+','-','/','*' operators are accepted, roman and arabic numbers CANNOT be used at the same time");
        } catch (BadFormatException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(1);

        }

        boolean roman = Parser.isRoman(name);
        System.out.println("using roman numerals: " + roman);
        String element0 = Parser.getElements(name)[0];
        String element1 = Parser.getElements(name)[1];
        String operator = Parser.getOperator(name);
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

    }
}
