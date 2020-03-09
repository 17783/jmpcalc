package com.example.jmp.calc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        if (!Parser.checkInputValidity(name)) {
            System.out.println("bad format");
            System.exit(1);
        }

        boolean roman = Parser.isRoman(name);
        System.out.println("using roman numerals: " + roman);
        String element0 = Parser.getElements(name)[0];
        String element1 = Parser.getElements(name)[1];
        String operator = Parser.getOperator(name);
        if (roman) {
            Parser.checkElementSize(Integer.toString(Parser.getArabic(element0)), Integer.toString(Parser.getArabic(element0)));
        } else {
            Parser.checkElementSize(element0, element1);
        }
//        Parser.checkElementSize(element0, element1);
//        String operator = operators[1];
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
