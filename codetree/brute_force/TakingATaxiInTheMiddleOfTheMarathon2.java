package codetree.brute_force;

import java.util.Scanner;

public class TakingATaxiInTheMiddleOfTheMarathon2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] checkPoints;

    /**
     * 의사코드
     *
     * 1. 1와 n번 체크포인트를 제외한 건너뛸 하나의 체크포인트에 대해 :: i
     *      1-1. 해당 체크포인트를 제외했을 때의 완주거리를 계산
     *          1-1-a. 만약 해당 완주거리가 최소값이라면 최소값으로 저장
     * 2. 완주 최소 거리 출력
     */
    public static void main(String[] args) {
        /* 입력 */
        // 체크포인트 개수 입력
        int n = scanner.nextInt();
        // 체크포인트 배열 생성
        checkPoints = new int[n][2];
        // 체크포인트들 입력
        for (int i = 0; i < n; i++) {
            checkPoints[i][0] = scanner.nextInt(); // x
            checkPoints[i][1] = scanner.nextInt(); // y
        }

        /* 연산 */
        int minDist = 0;
        // 건너뛸 체크포인트에 대해
        for (int i = 1; i < n - 1; i++) {
            int dist = 0;
            // 모든 포인트에 대해
            for (int j = 0; j < n; j++) {
                // 건너뛸 포인트 외 완주거리 연산
            }
            // 첫 완주이거나 최소값이라면 최소값 등록
            if (i == 1 || (dist < minDist)) {
                minDist = dist;
            }
        }

        /* 출력 */

    }
}
