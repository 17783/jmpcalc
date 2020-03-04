package com.example.jmp.calc;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static final String ELEMENT_DELIMITERS = "[+\\-*/ ]+";
    public static final String OPERATOR_DELIMITERS = "[a-z\\d\\s]+";

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("type in your operation:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        String[] elements = name.split(ELEMENT_DELIMITERS);
        String[] operators = name.split(OPERATOR_DELIMITERS);
        boolean roman;
        if (name.matches("[IVXivx+\\-*\\/ ]+")) {
           roman = true;
//            System.out.println("is roman");

        } else {
            roman = false;
//            System.out.println("is NOT roman");
        }

//        System.out.println(name);
        String element0 = elements[0];
        String element1 = elements[1];
        String operator = operators[1];
//        System.out.println(element0);
//        System.out.println("operator is:" + operator);
//        System.out.println(element1);
        if (!roman) {
            int element0Int = Integer.parseInt(element0);
            int element1Int = Integer.parseInt(element1);
            int result = Computer.compute(element0Int, element1Int, operator);
            System.out.println(name + " = " + result);
//            switch (operator) {
//                case "/":
//                    if (element1Int == 0) {
//                        System.out.println("DIVISION BY ZERO");
//                        break;
//                    } else {
//                        System.out.println(element0Int / element1Int);
//                    }
//                    break;
//                case "*":
//                    System.out.println(element0Int * element1Int);
//                    break;
//                case "-":
//                    System.out.println(element0Int - element1Int);
//                    break;
//                case "+":
//                    System.out.println(element0Int + element1Int);
//                    break;
//                default:
//                    System.out.println("Error: operation does not exist");
//                    break;
//            }
        }


//        for (int i=0; i<elements.length; i++) {
//            System.out.println(elements[i]);
//        }
//        for (int i=0; i<operators.length; i++) {
//            System.out.println(operators[i]);
//        }

    }
}
