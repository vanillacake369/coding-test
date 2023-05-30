package codetree.simulation_I;

import java.util.Scanner;

public class DateTimeToDateTime {

    /**
     * 의사코드
     *
     * > mod 연산으로 할 수는 없으려나
     *
     * 11일 11시 11분보다 이전이라면 -1
     * 11일 11시 11분보다 이후라면 루프
     *      c분이 60분에 도달하기 전까지 min ++
     *      c분이 60분에 도달하면 b분++, c분 초기화
     *      b시가 24시에 도달하기 전까지 ++
     *      b시가 24시에 도달하면 a일++, b시 초기화
     *      a일 b시 c분에 도달하면 루프를 중단
     * min 출력
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startD = 11; // 일
        int startH = 11; // 시
        int startM = 11; // 분
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int minCount = 0;

        if (a <= 11) {
            if (b < 11) {
                System.out.println(-1);
                return;
            }
            if (b == 11 && c < 11) {
                System.out.println(-1);
                return;
            }
        }

        while (true) {
            if (startD == a && startH == b && startM == c)
                break;

            if (startM >= 60) {
                startH++;
                startM = 0;
            }
            if (startH >= 24) {
                startD++;
                startH = 0;
            }

            startM++;
            minCount++;
        }
        System.out.println(minCount);

    }
}
