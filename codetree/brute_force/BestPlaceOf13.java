package codetree.brute_force;

import java.util.Scanner;

public class BestPlaceOf13 {

    // 스캐너
    private static final Scanner scanner = new Scanner(System.in);
    // 입력 격자 최대크기
    private static final int MAX_GRID_SIZE = 20;
    // 입력 격자
    private static int[][] grid = new int[MAX_GRID_SIZE][MAX_GRID_SIZE];
    // 1*3 격자 내의 1의 개수 최대 등장값
    private static int maxCount = 0;

    /**
     * 의사코드
     *
     * 1. n * n 격자를 입력받는다.
     * 2. 각 row 의 모든 column 을 순회하면서
     *      2-1. 1*3의 끝이 마지막 column 을 넘어선다면 다음 row 로 넘어간다.
     *      2-2. 만약 1*3의 끝이 마지막에 도달했다면 루프를 중단한다.
     *      2-3. 1*3 내에 1의 개수를 센다.
     *      2-4. 이전 1*3 내의 1의 개수보다 크다면 최대값으로 저장한다.
     * 3. 저장한 1*3 내의 1의 개수 최대값을 출력한다.
     */
    public static void main(String[] args) {

        /* 입력 */
        // n 입력
        int n = scanner.nextInt();
        // 격자 입력
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = scanner.nextInt();

        /* 연산 */
        // 각 row를 순회하며
        for (int i = 0; i < n; i++) {
            // 각 column을 순회하며
            for (int j = 0; j < n; j++) {
                // 1*3의 끝이 마지막 column을 넘어섰다면 넘어간다.
                // :: 마지막 row는 마지막이므로 아예 루프 중단됨
                if (j + 2 > n) {
                    if (i == n - 1) {
                        break;
                    }
                }

                // 1*3 내의 1의 갯수를 센다.
                int count = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];

                // 이전 1*3의 최대값보다 크다면 최대값으로 저장한다.
                if (count >= maxCount)
                    maxCount = count;
            }
        }

        /* 출력 */
        System.out.println(maxCount);

    }
}
