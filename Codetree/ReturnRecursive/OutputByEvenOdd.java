package Codetree.ReturnRecursive;

import java.util.Scanner;

public class OutputByEvenOdd {
    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        /* 연산 */
        int sumResult = getSumByEvenOdd(n);

        /* 결과 */
        System.out.println(sumResult);
    }

    private static int getSumByEvenOdd(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return n + getSumByEvenOdd(n - 2);
    }
}
