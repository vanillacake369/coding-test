package codetree.lv2.returning_functions;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputStr[0]);
        String op = inputStr[1];
        int b = Integer.parseInt(inputStr[2]);
        // calc
        // result
        printResult(a, b, op);
    }

    private static void printResult(int a, int b, String op) {
        if (op.equals("+")) {
            printPlusOp(a, b);
        } else if (op.equals("-")) {
            printMinusOp(a, b);
        } else if (op.equals("*")) {
            printMultOp(a, b);
        } else if (op.equals("/")) {
            printDivOp(a, b);
        } else {
            printFalse();
        }
    }

    private static void printFalse() {
        System.out.println("False");
    }

    private static void printDivOp(int a, int b) {
        System.out.println(a + " / " + b + " = " + (int) (a / b));
    }

    private static void printMultOp(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    private static void printMinusOp(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    private static void printPlusOp(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}
