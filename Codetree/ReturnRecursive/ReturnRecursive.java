package Codetree.ReturnRecursive;

import java.util.Scanner;

public class ReturnRecursive {
    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /* calc */
        int sum = getSumTo(n);
        /* result */
        System.out.println(sum);
    }

    private static int getSumTo(int n) {
        if (n == 1)
            return 1;
        return (n + getSumTo(--n));
    }
}
