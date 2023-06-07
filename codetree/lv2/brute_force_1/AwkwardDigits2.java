package codetree.lv2.brute_force_1;

import java.util.Scanner;

public class AwkwardDigits2 {

    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_A_LENGTH = 10;
    private static int[] inputArr = new int[MAX_A_LENGTH];

    /**
     * 의사코드
     *
     * 1. 숫자 하나를 바꾼다.
     * 2. 2진법으로 된 숫자배열을 10진수의 값으로 바꾼다.
     * 3. 구한 10진수가 최대값인지 판별한다.
     * */
    public static void main(String[] args) {
        /* 입력 */
        String aStr = scanner.next();
        int aLength = aStr.length();
        for (int i = 0; i < aLength; i++) {
            inputArr[i] = aStr.charAt(i) - '0';
        }

        /* 연산 */
        // 최대값
        int maxValue = 0;
        for (int i = 0; i < aLength; i++) {
            // 10진수 연산
            int value = 0;
            for (int j = 0; j < aLength; j++) {
                int digitDecimal = (i == j)
                        ? (int) (Math.pow(2, aLength - 1 - j) * ((inputArr[j] + 1) % 2))
                        : (int) (Math.pow(2, aLength - 1 - j) * inputArr[j]);
                value += digitDecimal;
            }

            // 연산된 10진수가 최대값인지 판별
            if (value >= maxValue)
                maxValue = value;
        }

        /* 출력 */
        System.out.println(maxValue);
    }

}
