package com.example.jmp.calc;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static final String ELEMENT_DELIMITERS = "[+\\-*/ ]+";
    public static final String OPERATOR_DELIMITERS = "[a-z\\d\\s]+";
    public static final String ROMAN_CHECK = "[IVXivx+\\-*\\/ ]+";

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        String[] elements = name.split(ELEMENT_DELIMITERS);
        String[] operators = name.split(OPERATOR_DELIMITERS);
        boolean roman;
        if (name.matches(ROMAN_CHECK)) {
           roman = true;
            System.out.println("is roman");

        } else {
            roman = false;
            System.out.println("is NOT roman");
        }

//        System.out.println(name);
        String element0 = elements[0];
        String element1 = elements[1];
        String operator = operators[1];
//        System.out.println(element0);
//        System.out.println("operator is:" + operator);
//        System.out.println(element1);
        int element0Int;
        int element1Int;
        if (!roman) {
            element0Int = Integer.parseInt(element0);
            element1Int = Integer.parseInt(element1);
        } else {
            element0Int = Parser.parseRoman(element0);
            element1Int = Parser.parseRoman(element1);
        }
            int result = Computer.compute(element0Int, element1Int, operator);
            System.out.println(name + " = " + result);



    }
}
