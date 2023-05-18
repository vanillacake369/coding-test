package codetree.brute_force;

import java.util.Scanner;

public class ARoomInACircle {

    private static int[] rooms;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        rooms = new int[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = scanner.nextInt();
        }

        int minDist = 0;
        // 시작할 방
        for (int i = 0; i < n; i++) {
            int dist = 0;
            // 모든 방에 상응하는 인원 이동거리 연산
            for (int j = 0; j < n; j++) {
                System.out.println(" 시작 방 : " + i);
                System.out.println(" rooms[((i+j)%n)]*j : " + rooms[((i + j) % n)] * j);
                dist += rooms[((i + j) % n)] * j;
            }
            if (i == 0)
                minDist = dist;
            if (dist < minDist)
                minDist = dist;
        }

        System.out.println(minDist);

    }
}
