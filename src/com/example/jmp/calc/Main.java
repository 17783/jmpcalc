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
//        System.out.println(name);
        int element0 = Integer.parseInt(elements[0]);
        int element1 = Integer.parseInt(elements[1]);
        String operator = operators[1];
        System.out.println(element0);
        System.out.println("operator is:" + operator);
        System.out.println(element1);
        switch (operator) {
            case "/":
                if (element1 == 0) {
                    System.out.println("DIVISION BY ZERO");
                    break;
                } else {
                    System.out.println(element0 / element1);
                }
                break;
            case "*":
                System.out.println(element0 * element1);
                break;
            case "-":
                System.out.println(element0 - element1);
                break;
            case "+":
                System.out.println(element0 + element1);
                break;
            default:
                System.out.println("Error: operation does not exist");
                break;
        }


//        for (int i=0; i<elements.length; i++) {
//            System.out.println(elements[i]);
//        }
//        for (int i=0; i<operators.length; i++) {
//            System.out.println(operators[i]);
//        }

    }
}
