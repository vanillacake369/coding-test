package thisiscodingtest.ch4_implement;

import java.util.Scanner;

public class RightLeftDownUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 공간의 크기 N
        scanner.nextLine(); // scanner 버퍼 비워주기
        String plan = scanner.nextLine(); // 계획서

        String[] planArr = plan.split(" "); // 계획서 배열
        int[][] vertexes = new int[n][n]; // 공간 배열

//         동 서 남 북
//        int[] dx = {1, -1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//        (X)
        // right move : [x][y] => [x][y+1]
        // left move : [x][y] => [x][y-1]
        // up move : [x][y] => [x-1][y]
        // down move : [x][y] => [x+1][y]
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] pl = {"L", "R", "U", "D"};

//        X. 요구사항으로 최초 좌표가 1,1이라고 나와있음
//        int finalX = 1;
//        int finalY = 1;
        int finalX = 1;
        int finalY = 1;
        for (String p : pl) {
            int nx = 0;
            int ny = 0;
            for (int i = 0; i < dx.length; i++) {
                // 입력값이 동서남북 배열에 일치하면 이동
                if (pl[i] == p) {
                    System.out.println("dx : " + dx[i]);
                    System.out.println("dy : " + dy[i]);
                    nx += dx[i];
                    ny += dy[i];
                }
                // 공간 밖을 벗어나면 무시
                if (nx < 0 || nx > n || ny < 0 || ny > n) {
                    continue;
                }
                finalX += nx;
                finalY += ny;
            }
        }

        System.out.println(finalX);
        System.out.println(finalY);

    }
}
