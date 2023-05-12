package codetree.simulation_II;

import java.util.Scanner;

public class ComeBack {
    /**
     * 자기 리뷰
     * 1. 꼼수 쓰지 말자.
     *      > +=,-=으로 풀려했으나 꼼수가 통하지 않았다. 이동마다 확인해야하는 문제이기 때문이다.
     *      > 이러한 문제는 애초에 dx,dy 배열을 아느냐를 물어보기에
     *      > 꼼수는 되도록이면 "지양"하자
     * 2. 하나의 플래그를 여러 로직이 사용하면, 플래그를 public static으로 선언하자
     *      > 본 로직은 각 방향에 따른 이동마다 시간을 늘리고, 체크한 뒤, 시간을 반환해야한다.
     *      > 모든 방향로직이 시간플래그를 의존(사용)하기 때문이 분리가 안 되었다.
     *      > 이를 해설에서는 시간 플래그를 public static으로 두어 해결하였다.
     *      > *** 하나의 플래그를 여러 로직이 사용하면, 플래그를 public static으로 하자 ***
     */


    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     * 1. dx,dy 배열을 선언한다.
     * 2. 각 방향입력에 따라 스칼라입력값만큼의 dx,dy 배열을 더한다.
     *      2-1. 한 칸씩 이동할 때마다 이동횟수를 +1 증가한다.
     *      2-2. 이동 도중 0,0으로 재귀했다면, 이동횟수를 반환한다.
     *      2-3. 재귀하지 않았다면 -1을 반환한다.
     * 3. 이동횟수를 출력한다.
     */
    public static void main(String[] args) {

        /* 환경 설정 */
        // 초기 좌표
        int[] point = {0, 0};
        // dx,dy 배열 :: N(0,1),S(0,-1),E(1,0),W(-1,0)
        final int[] dx = {0, 0, 1, -1};
        final int[] dy = {1, -1, 0, 0};
        // 시간
        int time = -1;

        /* 입력 */
        // 입력횟수
        int n = scanner.nextInt();

        /* 연산 */
        time = move(point, dx, dy, n);

        /* 출력 */
        System.out.println(time);

    }

    private static int move(int[] point, int[] dx, int[] dy, int n) {

        // 재귀하기까지 걸린 시간
        int timeSpentToReturn = 0;

        // 입력횟수만큼 이동
        for (int i = 0; i < n; i++) {

            // 이동방향
            char direction = scanner.next().charAt(0);
            // 이동칸
            int scalar = scanner.nextInt();

            // N에 따른 이동
            if (direction == 'N') {
                for (int j = 1; j <= scalar; j++) {
                    point[0] += dx[0];
                    point[1] += dy[0];
                    ++timeSpentToReturn;
                    // 만약 재귀하였다면 이동시간 반환
                    if (hasReturned(point))
                        return timeSpentToReturn;
                }
            }
            // S에 따른 이동
            if (direction == 'S') {
                for (int j = 1; j <= scalar; j++) {
                    point[0] += dx[1];
                    point[1] += dy[1];
                    ++timeSpentToReturn;
                    // 만약 재귀하였다면 이동시간 반환
                    if (hasReturned(point))
                        return timeSpentToReturn;
                }
            }
            if (direction == 'E') {
                for (int j = 1; j <= scalar; j++) {
                    point[0] += dx[2];
                    point[1] += dy[2];
                    ++timeSpentToReturn;
                    // 만약 재귀하였다면 이동시간 반환
                    if (hasReturned(point))
                        return timeSpentToReturn;
                }
            }
            if (direction == 'W') {
                for (int j = 1; j <= scalar; j++) {
                    point[0] += dx[3];
                    point[1] += dy[3];
                    ++timeSpentToReturn;
                    // 만약 재귀하였다면 이동시간 반환
                    if (hasReturned(point))
                        return timeSpentToReturn;
                }
            }
        }
        return -1;
    }

    private static boolean hasReturned(int[] point) {
        // 재귀하였다면 true, 아니라면 false
        if (point[0] == 0 && point[1] == 0) {
            return true;
        }
        return false;
    }
}
