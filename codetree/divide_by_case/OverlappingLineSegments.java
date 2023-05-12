package codetree.divide_by_case;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 의사코드 (X) => 틀림
 * "해설을 코멘트로 남깁니다"
 * 1. 선분의 좌표를 입력받는다.
 *      1-1. 좌표 리스트의 모든 좌표와 교차하는지 판별한다.
 *          1-1-a. 만약 어느 하나라도 교차한다면
 *             1-1-a-i. 좌표 교차 여부 플래그를 false로 바꾼다.
 *             1-1-a-ii. 교차판별 루프와 입력 루프를 탈출한다.
 *          1-1-b. 교차하지 않는다면 다음 좌표와 교차 여부를 판별한다.
 * 2. 좌표 교차 여부 플래그에 따라 교차 여부를 출력한다.
 */
public class OverlappingLineSegments {

    /* 좌표 객체 */
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 스캐너
    private static final Scanner scanner = new Scanner(System.in);

    // 좌표 리스트
    private static List<Point> pointList = new ArrayList<>();

    // 교차 여부 플래그
    private static boolean isCrossed = false;

    public static void main(String[] args) {

        /* 입력 */
        // 선분 개수 입력
        int n = scanner.nextInt();

        /* 연산 */
        checkEachInputLine(n);

        /* 출력 */
        printResult();


    }

    private static void printResult() {
        if (isCrossed == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void checkEachInputLine(int n) {
        for (int i = 0; i < n; i++) {
            // 선분 좌표 입력
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point p = new Point(x, y);
            // 기존 좌표들과 겹치는지 판별 : 겹치면 플래그 설정 후 종료,아니면 리스트에 추가
            if (i != 0 && hasCrossed(pointList, p)) {
                isCrossed = true;
                break;
            } else {
                pointList.add(p);
                continue;
            }
        }
    }

    private static boolean hasCrossed(List<Point> pointList, Point newPoint) {
        boolean isNewPointHasCrossed = false;
        for (Point previous : pointList) {
            // 안 겹치면 다음 포인트와 비교, 겹치면 true
            if (newPoint.y < previous.x || previous.y < newPoint.x)
                continue;
            else
                isNewPointHasCrossed = true;
        }
        return isNewPointHasCrossed;
    }
}
