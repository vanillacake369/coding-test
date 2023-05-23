package codetree.brute_force_1;

import java.util.Scanner;

public class CattleInARowingUp2 {

    // 스캐너 객체
    private static final Scanner scanner = new Scanner(System.in);
    // 입력 문자열 최대 개수
    private static final int MAX_INPUT_SIZE = 100;
    // 입력 문자열 리스트
    private static int[] cows = new int[MAX_INPUT_SIZE];
    // 조합의 개수
    private static int combiCount = 0;

    /**
     * 의사코드
     * 1. n마리의 소를 입력
     * 2. for ( i = 0 ~ i < n-2 )
     *      2-1. 소[i]에 대하여
     *          2-1-a. for ( j = i+1 ~ j < n-1 )
     *              2-1-a-i. for ( k = j+1 ~ k < n )
     *                  2-1-a-i-n. 소[i] <= 소[j] <= 소[k] 를 만족한다면 서로다른 쌍의 조합 수 증가
     * 3. 서로다른 쌍의 조합 수 출력
     */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            cows[i] = scanner.nextInt();
        }

        /* 연산 */
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((cows[i] <= cows[j]) && (cows[j] <= cows[k]))
                        combiCount++;
                }
            }
        }

        /* 출력 */
        System.out.println(combiCount);
    }
}
