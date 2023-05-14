package codetree.divide_by_case;

import java.util.Scanner;

public class TwoLines {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     * 1. x1 OR x2가 range(x3,x4)에 있다면 겹친다고 판단
     * 2. x3 OR x4가 range(x1,x2)에 있다면 겹친다고 판단
     */
    public static void main(String[] args) {
        /* 입력 */
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int x4 = scanner.nextInt();

        /* 교차 여부 판별 */
        boolean hasIntersected = isIntersected(x1, x2, x3, x4);

        /* 출력 */
        printResult(hasIntersected);
    }

    private static void printResult(boolean hasIntersected) {
        if (hasIntersected) {
            System.out.println("intersecting");
            return;
        }
        System.out.println("nonintersecting");
    }

    private static boolean isIntersected(int x1, int x2, int x3, int x4) {

        // x1 OR x2가 range(x3,x4)에 있다면 겹친다고 판단
        if (isInRangeOf(x3, x1, x2) || isInRangeOf(x3, x1, x2))
            return true;
        if (isInRangeOf(x1, x3, x4) || isInRangeOf(x2, x3, x4))
            return true;
        // 위 경우가 아니라면 거짓말
        return false;
    }

    /**
     * givenNum이 range1과 range2 사이에 존재한다면 true 반환
     * @param givenNum
     * @param range1
     * @param range2
     * @return
     */
    private static boolean isInRangeOf(int givenNum, int range1, int range2) {

        if (range1 <= givenNum && givenNum <= range2)
            return true;
        return false;
    }
}
