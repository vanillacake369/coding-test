package codetree.brute_force;

import java.util.Scanner;

public class Gather {

    // 스캐너 객체
    private static final Scanner scanner = new Scanner(System.in);
    // 집의 최대 개수
    private static final int MAX_N = 100;
    // 지점 별 사람 수 배열 :: [지점]=사람
    private static int[] peopleCountByPoint = new int[MAX_N];


    /**
     * 의사코드
     *
     * 1. n을 입력받는다.
     * 2. 거리 합을 지점 별로 구한다.
     * 3. 지점 별 거리 합 중 최소값을 찾는다.
     */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            peopleCountByPoint[i] = scanner.nextInt();
        }

        /* 연산 */
        int minDistSum = getMinDistSum(peopleCountByPoint, n);

        /* 출력 */
        System.out.println(minDistSum);

    }

    /**
     * 거리 합 중 최소값을 찾아 반환 :: O(n^2)
     *
     * 1. 각 지점마다의 거리합을 연산 // O(n^2)
     * 2. 연산한 "거리합" 을 이전값과 비교해서 최소값 찾기
     *
     * @param peopleCountByPoint
     * @param n
     * @return
     */
    private static int getMinDistSum(int[] peopleCountByPoint, int n) {

        // 지점 별 거리합 최솟값
        int minDistSum = 0;

        // i번째 집으로 모이면
        for (int i = 0; i < n; i++) {

            // 각 지점 별 거리합 연산
            int distSum = 0;

            // 이동 거리만큼
            for (int j = 0; j < n; j++) {
                // 각 지점마다의 거리합을 연산
                int dist = Math.abs(i - j);
                distSum += peopleCountByPoint[j] * dist;
            }

            // 1번째 이동거리합이면 거리합 최솟값으로 등록
            if (i == 0) {
                minDistSum = distSum;
                continue;
            }

            // 이전 거리합보다 연산한 거리합이 작다면
            if (distSum <= minDistSum) {
                // 연산한 거리합을 최솟값 등록
                minDistSum = distSum;
            }
        }

        return minDistSum;
    }
}
