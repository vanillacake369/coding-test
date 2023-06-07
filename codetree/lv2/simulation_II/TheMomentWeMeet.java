package codetree.lv2.simulation_II;

import java.util.Scanner;

public class TheMomentWeMeet {

    // 스캐너
    private static final Scanner scanner = new Scanner(System.in);
    // n,m,t의 최대값
    private static final int maxLength = 1000000;
    // A와 B의 이동 리스트
    private static int[] aMoveInstructs = new int[maxLength + 1];
    private static int[] bMoveInstructs = new int[maxLength + 1];
    // A와 B에 상태 리스트
    private static int[] aState = new int[maxLength + 1];
    private static int[] bState = new int[maxLength + 1];
    // 시간 포인터
    private static int present = 0;

    /**
     * 의사코드
     * 1. A와 B의 이동 리스트(배열)를 생성한다 :: [ 인덱스 ] => 이동벡터(+/- * 이동시간)
     * 2. A와 B에 상태 리스트(배열)를 생성한다 :: [ 인덱스 : 시간 ] => 값 : 현재 위치
     * 3. 입력방향과 값에 따라 A와 B를 움직인다.
     * 4. A와 B의 상태 배열을 시간 순서대로 비교한다.
     *      4-1. A와 B의 상태 배열이 서로 같다면
     *          4-1-a. 같은 값의 인덱스를 - 시간을 - 반환
     *      4-2. A와 B의 상태 배열이 서로 다르다면
     *          4-2-a. -1을 반환
     */
    public static void main(String[] args) {

        /* 입력 */
        // n,m 입력
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // A,B 이동 입력
        insertMove(aMoveInstructs, n);
        insertMove(bMoveInstructs, m);

        /* 연산 */
        // A,B 이동
        move(aMoveInstructs, aState, n);
        move(bMoveInstructs, bState, m);
        // A,B 상태배열을 확인하여 이동 간에 만나게 되는 시간 가져오기
        int timeWhenMet = getTimeWhenMet(aState, bState);

        /* 출력 */
        System.out.println(timeWhenMet);

    }

    private static void move(int[] moveInstructs, int[] state, int instructCount) {

        present = 0;
        // 이동명령 개수만큼
        for (int i = 0; i < instructCount; i++) {
            int instruct = moveInstructs[i];
            // 만약 오른쪽 이동이라면 +
            if (instruct > 0) {
                for (int j = 0; j < instruct; j++) {
                    state[present + 1] = state[present] + 1;
                    present++;
                }
            }
            // 만약 왼쪽 이동이라면 -
            if (instruct <= 0) {
                for (int j = 0; j > instruct; j--) {
                    state[present + 1] = state[present] + -1;
                    present++;
                }
            }
        }
    }

    private static int getTimeWhenMet(int[] aState, int[] bState) {

        // 상태 배열을 비교 :: 값이 같다면 만난 것이므로 인덱스(시간값) 반환
        for (int i = 1; i < present; i++) {
            if (aState[i] == bState[i])
                return i;
        }

        // 만나지 않았다면 -1
        return -1;
    }

    private static void insertMove(int[] moveInstructs, int n) {

        // 이동방향과 이동시간 입력하기
        for (int i = 0; i < n; i++) {
            // 이동방향 : R이면 +1, L이면 -1을 저장
            String direction = scanner.next();
            int directionVector = +1;
            if (direction.equals("L"))
                directionVector = -1;
            // 이동시간
            moveInstructs[i] = (scanner.nextInt() * directionVector);
        }
    }
}
