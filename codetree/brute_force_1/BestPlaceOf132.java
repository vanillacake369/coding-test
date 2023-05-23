package codetree.brute_force_1;

import java.util.Arrays;
import java.util.Scanner;

public class BestPlaceOf132 {

    // 스캐너
    private static final Scanner scanner = new Scanner(System.in);
    // 입력 격자 최대크기
    private static final int MAX_GRID_SIZE = 20;
    // 입력 격자
    private static int[][] grid = new int[MAX_GRID_SIZE][MAX_GRID_SIZE];
    // 각 행 별 동전최대값
    private static int[] maxCoinsEachRow;

    /**
     * 의사코드
     *
     * 1. 격자 정보를 입력
     * 2. 각 행에서 대해서 
     *      2-1. 1*3 격자 내에 존재하는 동전의 최대값을 찾는다.
     *      2-2. 찾은 최대값을 각 행 별로 저장한다.
     *          :: [행] = 동전최대값
     * 3. 각 행 별 동전최대값 중 최대 2개를 합친다.
     * 4. 합친 값을 출력
     *
     * Ex)
     * 0 0 0 1 1 :: maxCoinInGrid[0] = 2
     * 1 0 1 1 1 :: maxCoinInGrid[1] = 3
     * 0 1 0 1 0 :: maxCoinInGrid[2] = 2
     * 0 1 0 1 0 :: maxCoinInGrid[3] = 2
     * 0 0 0 1 1 :: maxCoinInGrid[4] = 2
     * => maxCoinInGrid배열의 최대값 두 개인 3,2의 합 5를 출력
     */
    public static void main(String[] args) {

        /* 입력 */
        // 격자 크기 입력
        int n = scanner.nextInt();
        // 격자 * 격자만큼 숫자 입력하여 입력격자 초기화
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                grid[j][k] = scanner.nextInt();
            }
        }
        // 각 행 별 동전최대값 배열 생성
        maxCoinsEachRow = new int[n];

        /* 연산 */
        // 각 행 별로 1*3 내의 동전 최대치를 저장
        getMaxCoinsEachRow(grid, maxCoinsEachRow, n);
        // 1*3 내의 동전 최대치 조합 중 최대값 찾기
        int maxCoinsInGrid = getMaxCoinsInGrid(maxCoinsEachRow);

        /* 출력 */
        System.out.println(maxCoinsInGrid);

    }

    private static int getMaxCoinsInGrid(int[] maxCoinsEachRow) {
        Arrays.sort(maxCoinsEachRow);
        return maxCoinsEachRow[maxCoinsEachRow.length - 1] + maxCoinsEachRow[maxCoinsEachRow.length - 2];
    }

    /**
     * 각 행 별로 1*3 내의 동전 최대치를 저장
     *
     * 1. 각 행애 대해
     *      1-1. 1*3 격자 조합 생성
     *      1-2. 이전 1*3 격자 조합보다 크다면 최대값으로 저장
     *      1-3. 찾은 최대값을 각 행 별로 저장한다.
     *
     *
     * @param grid
     * @param maxCoinsEachRow
     * @param n
     */
    private static void getMaxCoinsEachRow(int[][] grid, int[] maxCoinsEachRow, int n) {

        // 각 행에 대해
        for (int i = 0; i < n; i++) {

            // 행의 1*3 조합 중 최대값
            int maxCoins = 0;

            // i+3이 한 행의 끝에 도달할 때까지
            for (int j = 0; j + 2 < n; j++) {
                // 1*3 격자의 합
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                // 이전 1*3 격자 조합보다 크다면 최대값으로 저장
                if (sum >= maxCoins)
                    maxCoins = sum;
            }

            // 최대값을 각 행 별로 저장
            maxCoinsEachRow[i] = maxCoins;
        }
    }
}
