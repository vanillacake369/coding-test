package codetree.returning_functions;

import java.util.Scanner;

public class GetSumAndPrime {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputStr[0]);
        int b = Integer.parseInt(inputStr[1]);
        // calc
        int count = getCountOfSumIsPrime(a, b);
        // result
        System.out.println(count);
    }

    private static int getCountOfSumIsPrime(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i))
                if (hasSumOfEachDigitIsEven(i))
                    count++;
        }
        return count;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    private static boolean hasSumOfEachDigitIsEven(int i) {
        String iStr = Integer.toString(i);
        int sum = 0;
        for (int j = 0; j < iStr.length(); j++) {
            sum += (iStr.charAt(j) - '0');
        }
        if (sum % 2 == 0) {
            System.out.println("result num : " + i);
            return true;
        }
        return false;
    }

}
