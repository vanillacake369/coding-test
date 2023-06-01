package codetree.simulation_I;

import java.util.Hashtable;
import java.util.Scanner;

public class DayOfTheDay {
    static Hashtable<String, Integer> days = new Hashtable<>();
    static int[] calendar = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * 의사코드
     *
     * - 시작일과 마지막일 간 일수를 구해서
     * - 시작요일과 A요일 간의 일수를 구하고
     * - 시작요일과 A요일 간의 일수 + daysCount * 7 이 시작일과 마지막일 간 일수 범위 안에 있다면
     *      - A요일이 등장했다고 판단되므로 daysCount++;
     *      - 대신 daysCount 0부터 시작
     * - daysCount 출력
     */
    public static void main(String[] args) {
        days.put("Mon", 0);
        days.put("Tue", 1);
        days.put("Wed", 2);
        days.put("Thu", 3);
        days.put("Fri", 4);
        days.put("Sat", 5);
        days.put("Sun", 6);

        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int d2 = scanner.nextInt();
        String day = scanner.next();

        // A요일 등장횟수
        int daysCount = 0;

        // 시작일과 마지막일 간 일수를 구하기
        int daysBetweenD1D2 = getDaysBetweenD1D2(m1, d1, m2, d2);

        // 시작요일과 A요일 간의 일수를 구하기
        int daysBetweenA = days.get(day);
        while (true) {
            // 시작요일과 A요일 간의 일수 + daysCount * 7
            int nextDay = daysBetweenA + daysCount * 7;
            if (nextDay > daysBetweenD1D2)
                break;
            ++daysCount;
        }

        System.out.println(daysCount);
    }

    private static int getDaysBetweenD1D2(int m1, int d1, int m2, int d2) {
        int daysBetweenD1D2 = 0;
        int startMonth = 0;
        int startDate = 0;
        int endMonth = 0;
        int endDate = 0;

        // m1,d1 이 이전 날짜라면 m1,d1 기준으로 날짜를 센다.
        if ((m1 < m2) || (m1 == m2 && d1 <= d2)) { // 해당 조건을 잘못 만들어 계속 틀리느라 고생했다....
            startMonth = m1;
            startDate = d1;
            endMonth = m2;
            endDate = d2;
        }
        // m2,d2 이 이전 날짜라면 m2,d2 기준으로 날짜를 센다.
        else {
            startMonth = m2;
            startDate = d2;
            endMonth = m1;
            endDate = d1;
        }


        while (true) {
            if (startMonth == endMonth && startDate == endDate) {
                break;
            }
            if (startDate > calendar[startMonth]) {
                startMonth++;
                startDate = 1;
            }
            startDate++;
            daysBetweenD1D2++;
        }

        return daysBetweenD1D2;
    }
}
