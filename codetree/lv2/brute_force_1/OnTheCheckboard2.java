package codetree.lv2.brute_force_1;

import java.util.Scanner;

public class OnTheCheckboard2 {

    // 스캐너
    private static final Scanner scanner = new Scanner(System.in);
    // 입력 격자
    private static String[][] grid;
    // 경로 성공 카운트
    private static int pathCount = 0;

    /**
     * 의사코드
     *
     * 1. 각 행마다 가능한 경로의 개수를 모두 곱하여 출력한다.
     *      Ex) 
     *      W W W W W
     *      W W W W W => 1
     *      W B W W W => 1
     *      W W W W W => 2
     *      W W W W B => 1
     *
     *      따라서 가능한 경로의 개수는 1*1*2*1 = 2가지
     */
    public static void main(String[] args) {

        /* 입력 */
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        grid = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scanner.next();
            }
        }

        /* 연산 */
        pathCount = getSuccessivePathCount(grid);

        /* 출력 */
        System.out.println(pathCount);

    }

    /**
     * 이동 성공 경우 개수 반환하는 메서드
     *
     * 1. 각 row의 가능 경로 개수를 저장할 배열을 선언
     *      :: [row] => 가능경로개수
     * 2. 이전 색을 저장한다(초기에는 0,0의 색이다)
     * 3. 다음 열의 탐색 시작 인덱스 값을 저장한다.(초기에는 1이다)
     * 4. 각 row에 대해
     *      4-1. 각 column의 점프 가능 경로 수를 0으로 초기화한다.
     *      4-2. 각 column에 대해
     *          4-2-b. 이전 색과 다른 색이라면
     *              4-2-b-i. 처음 점프 가능 경로라면 다음 열의 탐색 시작값을 증가
     *              4-2-b-ii. 점프가능경로수를 증가한다.
     *      4-3. 해당 row의 점프가능경로수를 배열에 저장한다.
     * 5. 저장한 가능경로개수 배열에서 0보다 큰 모든 값을 곱하여 반환
     *
     * @param grid 색깔 배열
     * @return 시작->도착의 모든 경우의 수
     */
    private static int getSuccessivePathCount(String[][] grid) {
        // 각 row의 가능 경로 개수를 저장할 배열
        int[] eachRowPossiblePath = new int[grid.length];

        // 이전 색 저장 :: 초기에는 0,0의 색
        String previousColor = grid[0][0];
        // 다음 탐색 열의 시작 영역 :: 초기에는 1
        int previousColumn = 1;

        // 각 row마다
        for (int i = 1; i < grid.length; i++) {

            // 각 column의 점프 가능 경로 수
            int possiblePathInColumn = 0;

            // 각 column마다
            for (int j = previousColumn; j < grid[0].length - 1; j++) {

                // 만약 다른 색이라면
                if (!grid[i][j].equals(previousColor)) {

                    // 초기 가능 경로라면 다음 탐색 시작 열을 증가
                    if (possiblePathInColumn == 0)
                        previousColumn++;

                    // 점프 가능 경로 수를 증가
                    possiblePathInColumn++;
                }
            }

            // 만약 점프가능하다면 반대색이 존재하는 것이므로 다음 루프를 위해 이전 색값을 변경
            if (possiblePathInColumn > 0) {
                if (previousColor.equals("W")) {
                    previousColor = "R";
                } else {
                    previousColor = "W";
                }
            }

            // 각 row의 가능경로개수 배열에 저장
            eachRowPossiblePath[i] = possiblePathInColumn;

        }

        // 각 row의 가능경로개수 배열에서 1보다 큰 값들을 모두 곱함
        int allPossiblePathCount = 1;
        for (int i = 1; i < eachRowPossiblePath.length; i++) {
            if (eachRowPossiblePath[i] > 0)
                allPossiblePathCount *= eachRowPossiblePath[i];
        }

        // 모든 가능 경로를 반환
        return allPossiblePathCount;
    }
}
