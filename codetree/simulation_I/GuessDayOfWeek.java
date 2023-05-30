package codetree.simulation_I;

import java.util.Hashtable;
import java.util.Scanner;


/**
 * 시뮬레이션 > 요일 맞추기
 * https://www.codetree.ai/missions/5/problems/guess-day-of-week/explanation
 *
 * Intuition
 * 흐른 날짜의 경우 1월 1일을 기준으로 계산하여 그 차이를 구하고,
 * 요일의 경우 7로 나눈 나머지를 이용해 계산할 수 있습니다.
 *
 * Algorithm
 * 요일을 구하기 위해서는, 총 몇일이 흘렀는지를 먼저 계산해야 합니다.
 * 이는 직접 시뮬레이션을 하는 것 보다는, 1월 1일을 기준으로 계산하여 각 날짜까지의 일 수를 구해
 * 그 차이를 구하는 식으로 진행이 가능합니다.
 * 그 후 7로 나눈 나머지를 계산하면, 요일 계산이 간단하게 가능해집니다.
 */

public class GuessDayOfWeek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int d2 = scanner.nextInt();
        int[] daysByMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        /* 경과 일수 구하기 : 이전 달이라면 줄여가며 세고, 이후 달이라면 더해가며 센다 */
        // X

        /*int daysPassed = 0;
        // 이전달이라면 줄여가며 세기
        if (m1 >= m2 && d1 >= d2) {
            while (true) {
                if (m1 == m2 && d1 == d2)
                    break;

                d1--;
                daysPassed--;

                if (d1 < 0) {
                    --m1;
                    d1 = daysByMonth[m1];
                }
            }
        }
        // 이후달이라면 더해가며 세기
        if (m1 <= m2 && d1 <= d2) {
            while (true) {
                if (m1 == m2 && d1 == d2)
                    break;

                d1++;
                daysPassed++;

                if (d1 > daysByMonth[m1]) {
                    m1++;
                    d1 = 0;
                }
            }
        }*/
    }
}
