package codetree.lv2.simulation_I;

import java.util.Scanner;

public class DateToDate {

    /**
     * 의사코드
     *
     * 1. 각 월 별에 대한 일 수를 저장한다.
     * 2. 날짜 간 일수를 센다.
     *      (m1월에 대한 최대일수 - d1)
     *          + 다음 달의 일 수
     *          + 다음 다음 달의 일 수
     *          + ... + d2일 수
     *
     */
    public static void main(String[] args) {
        int[] calendar = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int d2 = scanner.nextInt();

        int days = 0;
        while (true) {
            // m2월 d2일에 도달하면 날짜 세기 중단
            if (m1 == m2 && d1 == d2) {
                days++;
                break;
            }
            days++;
            d1++;

            // 만약 최대일수를 넘기면 다음 월로 넘어감
            if (d1 > calendar[m1 - 1]) {
                m1++;
                d1 = 1;
            }
        }

        System.out.println(days);
    }
}
