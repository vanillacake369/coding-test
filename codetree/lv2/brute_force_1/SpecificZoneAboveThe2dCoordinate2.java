package codetree.lv2.brute_force_1;

import java.util.Scanner;

public class SpecificZoneAboveThe2dCoordinate2 {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     *
     * 1. n을 입력받는다.
     * 2. [n][n] 크기의 이차원배열을 생성한다.
     * 3. n개의 좌표에 대하여
     *      하나의 좌표를 빼보고
     *      x에 대한 루프를 통해 x간의 차이가 최대값 => 가로
     *      y에 대한 루프를 통해 y간의 차이가 최대값 => 세로
     *      가로 * 세로 값이 최소값이라면 넓이최소값으로 저장
     * 4. 넓이최소값을 출력
     */
    public static void main(String[] args) {

        int n = scanner.nextInt();
        int[][] points = new int[n][n];

        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        int minArea = 40000 * 40000; // 초기에는 최대 직사각형 넓이로, 이후 최소값 찾으면 최소값으로 저장

        for (int i = 0; i < n; i++) {

            int maxWidth = 0; // 초기에는 최소 직사각형 가로로, 이후 최대값 찾으면 최대값으로 저장
            int maxHeight = 0; // 초기에는 최소 직사각형 세로로, 이후 최대값 찾으면 최대값으로 저장

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i == j || i == k)
                        continue;
                    if (Math.abs(points[j][0] - points[k][0]) > maxWidth)
                        maxWidth = Math.abs(points[j][0] - points[k][0]);
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i == j || i == k)
                        continue;
                    if (Math.abs(points[j][1] - points[k][1]) > maxHeight)
                        maxHeight = Math.abs(points[j][1] - points[k][1]);
                }
            }

            if (maxWidth * maxHeight < minArea)
                minArea = maxWidth * maxHeight;
        }

        System.out.println(minArea);
    }
}
