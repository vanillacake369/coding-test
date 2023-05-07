package codetree.return_recursive;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        /* 팩토리얼 연산 */
        int factResult = getFactorial(n);

        /* 결과 */
        System.out.println(factResult);
    }

    private static int getFactorial(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        return n * getFactorial(n - 1);
    }
}
