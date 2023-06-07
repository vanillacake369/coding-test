package codetree.lv2.simulation_II;

import java.util.Scanner;

public class RobotMovingFromSideToSide {

    /* 전역 변수 */
    // 스캐너 객체
    private static final Scanner scanner = new Scanner(System.in);
    // 서로 마주친 횟수
    private static int crossCount = 0;
    // 최대 움직인 거리의 총 합
    private static final int MAX_MOVE_COUNT = 1000000;
    // 로봇 A 상태배열
    private static int[] stateA = new int[MAX_MOVE_COUNT + 1];
    // 로봇 B 상태배열
    private static int[] stateB = new int[MAX_MOVE_COUNT + 1];
    // 로봇 간 최대 이동수
    private static int maxMoveOfRobots = 0;

    /**
     * 의사코드
     *
     * 1. 로봇 A와 로봇 B에 대한 상태 배열 생성
     * 2. 로봇 A와 로봇 B 모든 이동을 수행 :: 로봇 A,B의 상태배열 변화
     *      2-1.
     * 3. 두 상태배열을 인덱스 별로 - 시간 별로 - 비교
     *      3-1. 만약 i번째 값이 서로 같다면
     *          3-1-a. 바로 직전값인 i-1번째 값이 서로 같다면
     *              3-1-a-i. 서로 마주친 횟수를 늘린다.
     *          3-1-b. 바로 직전값인 i-1번째 값이 서로 다르다면
     *              3-1-b-i. 무시한다.(서로 마주쳤다고 판단하지 않음)
     * 4. 서로 마주친 횟수 출력
     */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        /* 연산 */
        // 로봇 A와 로봇 B 모든 이동 수행
        move(stateA, n);
        move(stateB, m);
        // 최대 이동수만큼 로봇 A와 로봇 B 비교
        crossCount = getCrossCount(maxMoveOfRobots, stateA, stateB);

        /* 출력 */
        System.out.println(crossCount);


    }

    /**
     * 바로 직전에는 다른 위치에 있다가 그 다음 번에 같은 위치에 오게 되는지 판별 함수
     *
     * 1. 최대 이동수만큼 비교
     *      1-1. 다른 위치에 있다가 그 다음 번에 교차하면 교차 횟수 증가
     * 2. 교차횟수 반환     
     * @param maxMoveOfRobots
     * @param stateA
     * @param stateB
     * @return
     */
    private static int getCrossCount(int maxMoveOfRobots, int[] stateA, int[] stateB) {

        int crossCount = 0;
        for (int i = 1; i <= maxMoveOfRobots; i++) {
            if (stateA[i] == stateB[i])
                if (stateA[i - 1] != stateB[i - 1])
                    crossCount++;
        }
        return crossCount;
    }

    /**
     * 로봇 이동 제어 후, 최대 이동칸수 추출
     *
     * 1. 입력값에 따라 로봇 이동 :: getIndexPointerAfterMove 호출
     * 2. 로봇이 움직임을 종료한 이후,  같은 위치에 계속 머물러 있게 나머지 인덱스르 현 위치로 모두 초기화
     * 3. 최대 이동칸수 비교 후, 초기화
     *
     * @param state
     * @param instNum
     */
    private static void move(int[] state, int instNum) {

        // 상태배열 인덱스 포인터
        int indexPointer = 0;

        // 입력값에 따라 로봇 이동하여 로봇 상태 배열 변화 
        indexPointer = getIndexPointerAfterMove(state, instNum, indexPointer);

        // 현재 ~ 미래 위치 대해 현재 위치로 고정!!
        for (int i = indexPointer; i < MAX_MOVE_COUNT; i++) {
            state[i + 1] = state[i];
        }

        // 만약 다른 로봇보다 이동수가 더 많다면 최대 이동수를 본인 이동수로 초기화
        if (indexPointer >= maxMoveOfRobots)
            maxMoveOfRobots = indexPointer;

    }

    /**
     * 실제 모든 이동 수행 이후, 최종 위치 반환
     *
     * 1. 모든 이동칸수, 이동방향을 입력
     * 2. " 다음인덱스 <= 이전 인덱스 +1/-1 " 수행
     * 3. 마지막으로 이동한 인덱스의 값을 반환
     * @param state
     * @param instNum
     * @param indexPointer
     * @return
     */
    private static int getIndexPointerAfterMove(int[] state, int instNum, int indexPointer) {
        // 명령의 개수만큼 이동칸수 이동방향 입력
        for (int i = 0; i < instNum; i++) {

            // 이동칸수 입력
            int moveInput = scanner.nextInt();
            // 이동방향 입력
            String direction = scanner.next();

            // 이동방향이 L이면 이동칸수만큼의 루프를 통해 - 이동
            if (direction.equals("L")) {
                for (int j = 0; j < moveInput; j++) {
                    state[indexPointer + 1] = state[indexPointer] - 1;
                    indexPointer++;
                }
            }
            // 이동방향이 R이면 이동칸수만큼의 루프를 통해 + 이동
            if (direction.equals("R")) {
                for (int j = 0; j < moveInput; j++) {
                    state[indexPointer + 1] = state[indexPointer] + 1;
                    indexPointer++;
                }
            }
        }
        return indexPointer;
    }
}
