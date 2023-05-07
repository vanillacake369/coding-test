package codetree.returning_functions;

import java.util.Scanner;

public class GetPowerOfNumber {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputStr[0]);
        int b = Integer.parseInt(inputStr[1]);
        int result = 1;
        // calc
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        // result
        System.out.println(result);
    }
}
