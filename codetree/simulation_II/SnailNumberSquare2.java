package codetree.simulation_II;

import java.util.Scanner;

public class SnailNumberSquare2 {
    /**
     * 의사코드
     *
     * n 행 m 열의 이차원배열의 달팽이배열 생성
     * 이차원배열을 통해 방향벡터 하,우,상,좌 순으로 선언
     * 다음 방향이 이동 불가능하다면 방향전환 (방향전환은 i = (i+1)%4 을 사용)
     *      만약 방향전환 이후 바로 다음 이동이 불가하다면 이동 중단
     *      * 이동 불가 조건은 1. 끝에 도달 2. 다음 이동칸이 채워져있음
     * 다음 방향이 이동 가능하다면 이동
     * 달팽이 출력
     */
    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int snailrow = 0;
        int snailcol = 0;
        int[][] snail = new int[n][m];
        int[][] vector = { // 하,우,상,좌,
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        int nextVector = 0;
        int moveCount = 1;

        /* 이동 */
        /*
         * 만약 n*m번만큼 이동하라고 지정하지 않으면, 가장 안쪽 테두리 내부에서 무한하게 돌게된다.
         *
         * 왜냐하면 마지막 이동에 대해서는 어느 방향으로 전환하건 못 간다는 판별을 해주어야 하는데
         * 이에 대한 조건식이 없기 때문이다.
         *
         * 우리는 방향 전환 조건이 다음 칸에 대해 갔던 칸이거나 ,끝에 도달했는지를 체크한다.
         * 다만 마지막 이동만큼은 상하좌우 방향으로 이동할 수 있는지 체크해야한다.
         * 따라서 상하좌우를 모두 체크하는 조건이 없기 때문에 무한반복하며 내부를 돈다.
         *
         * 그래서 그냥 n*m만큼 이동하라고 지정하는 게 편하다.
         * */
        for (int i = 0; i < n * m; i++) {
            // 이동 카운트
            snail[snailrow][snailcol] = moveCount++;

            // 다음 칸 지정
            int nextSnailRow = snailrow + vector[nextVector][0];
            int nextSnailCol = snailcol + vector[nextVector][1];

            // 다음칸이 끝에 도달했다면
            if (nextSnailRow == -1 || nextSnailRow == n || nextSnailCol == -1 || nextSnailCol == m) {
                // 방향 변경
                nextVector = (nextVector + 1) % 4;

                // 방향 변경 후 이미 지나간 칸이라면 이동 종료, 아니라면 다음칸으로 지정
                int nextVectorRow = snailrow + vector[nextVector][0];
                int nextVectorCol = snailcol + vector[nextVector][1];
                if (nextVectorRow == -1 || nextVectorRow == n || nextVectorCol == -1 || nextVectorCol == m)
                    break;
                if (snail[nextVectorRow][nextVectorCol] != 0)
                    break;
                else {
                    snailrow = nextVectorRow;
                    snailcol = nextVectorCol;
                    continue;
                }
            }

            // 다음칸이 이동했던 칸이라면
            if (snail[nextSnailRow][nextSnailCol] != 0) {
                // 방향 변경한 다음칸으로 지정
                nextVector = (nextVector + 1) % 4;
                snailrow += vector[nextVector][0];
                snailcol += vector[nextVector][1];
                continue;
            }

            // 다음 칸이 끝이나 이동했던 칸이 아니라면 그냥 이동
            snailrow = nextSnailRow;
            snailcol = nextSnailCol;
        }



        /* 출력 */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }

    }
}
