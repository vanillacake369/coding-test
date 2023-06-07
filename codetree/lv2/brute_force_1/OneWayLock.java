package codetree.lv2.brute_force_1;

import java.util.Scanner;

public class OneWayLock {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] lockNumbers = new int[3];
    private static int lockOpenedCombinationCount = 0;

    /**
     * 의사코드
     *
     * 1. n을 입력받는다.
     * 2. a,b,c를 입력받아 배열에 저장한다.
     * 3. 첫 자리에 대한 루프에 대해
     *      두 번째 자리에 대한 루프에 대해
     *          세 번째 자리에 대한 루프에 대해
     *              첫번째,두번째,세번쨰 자리가 하나라도 a,b,c와 2이내이면 열리는 조합 카운트
     * 4. 열리는 조합 카운트를 출력한다.
     */
    public static void main(String[] args) {

        int n = scanner.nextInt();

        for (int i = 0; i < 3; i++) {
            lockNumbers[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int subA = Math.abs(lockNumbers[0] - i);
                    int subB = Math.abs(lockNumbers[1] - j);
                    int subC = Math.abs(lockNumbers[2] - k);
                    if (subA <= 2 || subB <= 2 || subC <= 2)
                        lockOpenedCombinationCount++;
                }
            }
        }

        System.out.println(lockOpenedCombinationCount);
    }
}
