package codetree.brute_force_1;

import java.util.Scanner;

public class MaxSumOfSubarray {
    private static int[] subArr;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     *
     * 1. 모든 숫자들에 대해 :: i
     *      2. 연속수 n개에 대해 :: j
     *          2-1-a. n 개의 연속수를 합함
     *          2-1-b. 합이 최대값이라면 최대값으로 저장
     * 2. 최대값 출력
     */
    public static void main(String[] args) {

        /* 입력 */
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        subArr = new int[k];
        for (int i = 0; i < k; i++) {
            subArr[i] = scanner.nextInt();
        }

        /* 연산 */
        int maxSum = 0;
        for (int i = 0; i <= k - n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += subArr[i + j];
            }
            if (i == 0 || sum > maxSum)
                maxSum = sum;
        }

        /* 출력 */
        System.out.println(maxSum);

    }
}
