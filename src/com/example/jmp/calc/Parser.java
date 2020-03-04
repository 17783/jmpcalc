package com.example.jmp.calc;

public class Parser {
    public static int parseRoman(String element) {
        int result = 0;
        switch (element) {
            case "i":
                result = 1;
                break;
            case "ii":
                result = 2;
                break;
            case "iii":
                result = 3;
                break;
            case "iv":
                result = 4;
                break;
            case "v":
                result = 5;
                break;
            case "vi":
                result = 6;
                break;
            case "vii":
                result = 7;
                break;
            case "viii":
                result = 8;
                break;
            case "ix":
                result = 9;
                break;
            case "x":
                result = 10;

        }
        return result;
    }
}
