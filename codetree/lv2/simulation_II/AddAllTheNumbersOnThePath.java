package codetree.lv2.simulation_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAllTheNumbersOnThePath {

    static List<String> commandList = new ArrayList<>();
    static int[][] coordinates;

    static int[][] direction = {
            {-1, 0}, // 상
            {0, 1}, // 우
            {1, 0}, // 하
            {0, -1}  // 좌
    };

    // NOTE 예외 사항 : 단, 격자의 범위를 벗어나게 하는 명령어는 무시해야함에 유의합니다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 칸 수
        int t = scanner.nextInt(); // 명령어 수
        int startDirection = 0; // 시작 방향 : 상

        // 좌표 정의
        coordinates = new int[n][n];
        int startX = (n / 2);
        int startY = (n / 2);

        String commands = scanner.next();
        // 명령어들을 리스트에 저장
        for (int i = 0; i < t; i++) {
            String command = Character.toString(commands.charAt(i));
            commandList.add(command);
        }

        // 좌표 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates[i][j] = scanner.nextInt();
            }
        }

        // 초기 시작점을 이동경로에 합함
        int sumOfPassed = coordinates[startX][startY];
        // 명령에 따른 이동
        for (int i = 0; i < t; i++) {
            String command = commandList.get(i);

            // 왼쪽으로 전환
            if (command.equals("R")) {
                startDirection = (startDirection + 1) % 4;
            }
            // 오른쪽으로 전환
            if (command.equals("L")) {
                startDirection = (startDirection - 1) % 4;
                if (startDirection < 0)
                    startDirection += 4;
            }
            // 이동
            if (command.equals("F")) {
                // ** 이동 범위가 격자 내라면 이동 **
                if (isInRange(startX + direction[startDirection][0],
                        startY + direction[startDirection][1], coordinates)) {
                    startX += direction[startDirection][0];
                    startY += direction[startDirection][1];

                    sumOfPassed += coordinates[startX][startY];
                }
            }
        }

        System.out.println(sumOfPassed);
    }

    private static boolean isInRange(int startX, int startY, int[][] coordinates) {
        if (startX >= 0 && startX < coordinates.length
                && startY >= 0 && startY < coordinates.length)
            return true;
        return false;
    }
}
