package codetree.divide_by_case;

import java.util.Scanner;

public class TwoLines {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * "본 문제는 해설을 참고했습니다"
     * 의사코드 (X)
     * 1. x1 <= x3 <= x2 <= x4 라면 교차한다고 판별한다.
     *      => 주석처리
     */
    public static void main(String[] args) {

        /* 입력 */
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int x4 = scanner.nextInt();

        /* 연산 & 출력 */
        /* if (x1 <= x3 && x3 <= x2 && x2 <= x4) { => (X)   */
        // 해설 :: 안 겹치는 경우 먼저 처리
        if (x2 < x3 || x4 < x1) {
            System.out.println("nonintersecting");
            /*System.out.println("intersecting");*/
        } else {
            System.out.println("intersecting");
            /*System.out.println("nonintersecting");*/
        }
    }
}
