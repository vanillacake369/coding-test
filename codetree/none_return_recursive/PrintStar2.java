package codetree.none_return_recursive;

import java.util.Scanner;

public class PrintStar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printStar(n);
    }

    /*
     * printStar(5)
     * printStar(4)
     * printStar(3)
     * printStar(2)
     * printStar(1)
     * printStar(2)
     * printStar(3)
     * printStar(4)
     * printStar(5)
     * */
    /*
     * for : i = 5(input); i >= 1; i--
     *   printStar(input-1);
     * */
    private static void printStar(int n) {
        // 1. n만큼 star 출력
        for (int i = 0; i < n; i++) {
            System.out.print("*");
            if (i != n - 1)
                System.out.print(" ");
        }
        System.out.println("");
        // 2. 스택에 printStar(n-1) 호출
        // 2-1. 만약 1까지 다달았다면 재귀호출 스택 pop하여 caller로 돌아감
        if (n == 1) {
            System.out.println("*");
            return;
        } else {
            printStar(n - 1);
        }
        // 3. 재귀호출 스택에서 돌아온 뒤 다시 n만큼 star 출력
        for (int i = 0; i < n; i++) {
            System.out.print("*");
            if (i != n - 1)
                System.out.print(" ");
        }
        System.out.println("");
    }
}
