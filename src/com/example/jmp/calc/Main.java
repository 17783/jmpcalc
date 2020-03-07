package com.example.jmp.calc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static final String ELEMENT_DELIMITERS = "[+\\-*/ ]+";
    //    public static final String OPERATOR_DELIMITERS = "[a-zA-Z\\d\\s]+";
    public static final String OPERATOR_DELIMITERS = "[IVXivx\\d\\s]+";
    public static final String ROMAN_CHECK = "[IVXivx+\\-*\\/ ]+";

    public static void main(String[] args) throws IOException {

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        if (!Input.checkInputValidity(name)) {
            System.out.println("bad format");
            System.exit(1);
        }

        String[] elements = name.split(ELEMENT_DELIMITERS);
//        String[] operators = name.split(OPERATOR_DELIMITERS);
        String operator = name.split(OPERATOR_DELIMITERS)[1];
        boolean roman;
        roman = name.matches(ROMAN_CHECK);
        System.out.println("using roman numerals: " + roman);
        String element0 = elements[0];
        String element1 = elements[1];
        if (roman) {
            Input.checkElementSize(Integer.toString(Parser.getArabic(element0)), Integer.toString(Parser.getArabic(element0)));
        } else {
            Input.checkElementSize(element0, element1);
        }
        Input.checkElementSize(element0, element1);
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
