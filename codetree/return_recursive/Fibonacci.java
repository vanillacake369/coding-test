package codetree.return_recursive;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /* 피보나치 연산 */
        int nthFibonacci = getNthFibonacci(n);
        /* 피보나치 결과 */
        System.out.println(nthFibonacci);
    }

    /*
     * 첫번째와 두번째 피보나치 수는 종료 조건
     *      1. 첫번째 피보나치 수 : 1
     *      2. 두번째 피보나치 수 : 1
     * 이후의 피보나치 수는 다음 수열의 공식을 따름
     * fibonacci(n) = fibonacci(n-2) + fibonacci(n-1)
     */
    private static int getNthFibonacci(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return getNthFibonacci(n - 2) + getNthFibonacci(n - 1);
    }

}
