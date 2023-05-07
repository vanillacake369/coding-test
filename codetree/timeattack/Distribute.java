package codetree.timeattack;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Distribute {

    static class Box implements Comparable {
        private int width;
        private int height;

        Box(int width) {
            this.width = width;
        }

        public Box(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Box() {
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getSize() {
            return (this.height * this.width);
        }

        @Override
        public int compareTo(Object o) {
            Box box = (Box) o;
            if (this.getSize() > box.getSize())
                return -1;
            if (this.getSize() < box.getSize())
                return 1;
            return 0;
        }

        @Override
        public String toString() {
            return this.height + " " + this.width;
        }
    }

    private static List<Box> boxes = new LinkedList<>();

    private static final Scanner scanner = new Scanner(System.in);

    private static int boxCount = 0;

    /**
     * 의사코드
     * 1. 물건개수 n과 상자개수 k를 입력받는다.
     * 2. 각 상자의 세로,가로를 입력받는다.
     * 3. 상자들을 상자 리스트에 저장한다.
     * 4. 세로 x 가로가 가장 큰 순으로 상자 리스트를 정렬한다.
     * 5. 상자리스트를 순회하며 순차적으로 물건 - (세로 x 가로)를 한다.
     * 6. 사용 상자 카운트를 센다.
     * 7. 물건이 다 채워지지 않는다면 - 아직 0보다 크다면 - 다음 상자를 사용한다.
     * 8. 물건이 0보다 작아지면 멈춘다.
     */
    public static void main(String[] args) {
        /* 입력 */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // 버퍼 비우기
        scanner.nextLine();

        /* 연산 */
        // k개의 박스 저장
        storeBoxes(k);
        // 사이즈 순으로 정렬
        boxes = sortByBiggerSize(boxes);
        /*// 정렬 잘 되었는지 확인
        for (Box b : boxes) {
            System.out.println(b);
        }*/
        // 물건 분배
        distribute(n, boxes);

        /* 출력 */
        // 사용된 상자 개수 출력
        System.out.println(boxCount);
    }

    private static void distribute(int n, List<Box> boxes) {
        int i = 0;
        while (n > 0) {
            Box box = boxes.get(i);
            int size = box.getSize();
            n -= size;
            boxCount++;
            i++;
        }
    }

    private static List<Box> sortByBiggerSize(List<Box> boxes) {
        return boxes.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void storeBoxes(int k) {
        for (int i = 0; i < k; i++) {
            String[] inputStr = scanner.nextLine().split(" ");
            boxes.add(new Box(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1])));
        }
    }
}
