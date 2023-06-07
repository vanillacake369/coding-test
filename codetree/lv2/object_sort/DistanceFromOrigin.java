package codetree.lv2.object_sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class DistanceFromOrigin {

    private static final Scanner scanner = new Scanner(System.in);

    /* 점 객체 */
    static class Point implements Comparable {

        public Point(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        private int x;
        private int y;
        private int number;

        public int getNumber() {
            return number;
        }

        public int getManhattanDist() {
            return (Math.abs(this.x) + Math.abs(this.y));
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return this.getManhattanDist() - p.getManhattanDist();
        }
    }

    /**
     * 의사코드
     * 1. 점의 수만큼 점 객체를 입력받는다.
     * 2. 각 점 객체의 맨하탄 거리에 따라 정렬한다.
     * 3. 정렬된 점 객체들을 출력한다.
     */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();
        scanner.nextLine();

        /* 연산 */
        // 점 객체 리스트
        List<Point> pointList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pointList.add(new Point(x, y, (i + 1)));
        }
        // 맨하탄 거리에 따른 정렬
        pointList = pointList.stream().sorted().collect(Collectors.toList());

        /* 출력 */
        for (Point p : pointList) {
            System.out.println(p.getNumber());
        }

    }
}
