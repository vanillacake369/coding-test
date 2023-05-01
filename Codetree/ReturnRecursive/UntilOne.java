package Codetree.ReturnRecursive;

import java.util.Scanner;

public class UntilOne {
    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /* calc */
        int divideCount = getDivideCount(n, 0);
        /* result */
        System.out.println(divideCount);
    }

    private static int getDivideCount(int n, int count) {
        /* 종료조건 :: 몫이 1이 될 때까지 */
        if (n == 1)
            return count;
        /* 짝/홀에 따른 나눔 재귀호출 */
        // 짝수 :: func(n/2,count++)
        if (n % 2 == 0) {
            System.out.print("n/2 : " + (n / 2));
            System.out.println("count++ : " + (count + 1));
            return getDivideCount(n / 2, ++count);
        }
        // 홀수 :: func(n/3,count++)
        System.out.print("n/3 : " + (n / 3));
        System.out.println("count++ : " + (count + 1));
        return getDivideCount(n / 3, ++count);
    }
}
