package codetree.return_recursive;

import java.util.Scanner;

public class SquareOfEachNum {
    public static int sum(int n) {
        // 한 자리 숫자라면 제곱한 값이 결과가 됩니다.
        if (n < 10)
            return n * n;

        // 마지막 자리 숫자의 제곱에
        // 남은 숫자들의 합을 계산한 결과를 더해 반환합니다.
        int digit = (n % 10);
        return sum(n / 10) + digit * digit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.println(sum(n));
    }
}