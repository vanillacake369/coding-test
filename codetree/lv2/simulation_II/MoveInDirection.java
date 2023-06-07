package codetree.lv2.simulation_II;

import java.util.Scanner;

public class MoveInDirection {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     * 1. x,y를 double array 으로 표현한다.
     * 2. 이동횟수만큼 입력방향의 ASCII값에 따른 좌표이동한다.
     * 3. 최종 좌표를 출력한다.
     * */
    public static void main(String[] args) {

        // x,y 선언
        int[] point = {0, 0};

        // 이동횟수 입력
        int n = scanner.nextInt();

        // 이동횟수만큼 입력방향으로 이동
        for (int i = 0; i < n; i++) {
            char direction = scanner.next().charAt(0);
            int scalar = scanner.nextInt();
            // 입력방향의 ASCII값에 따른 이동함수 호출
            point = move(point, direction, scalar);
        }

        // 최종 좌표 출력
        System.out.println(point[0] + " " + point[1]);

    }

    private static int[] move(int[] point, char direction, int scalar) {
        if (direction == 'N')
            point[1] += scalar;
        if (direction == 'S')
            point[1] -= scalar;
        if (direction == 'E')
            point[0] += scalar;
        if (direction == 'W')
            point[0] -= scalar;
        return point;
    }

}
