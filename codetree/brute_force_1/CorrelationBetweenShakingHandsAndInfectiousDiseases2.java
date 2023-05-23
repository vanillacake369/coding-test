package codetree.brute_force_1;

import java.util.Arrays;
import java.util.Scanner;

public class CorrelationBetweenShakingHandsAndInfectiousDiseases2 {
    private static int[] developers; // 개발자 감염전파
    private static boolean[] infected; // 개발자 감염상태
    private static Handshake[] handshakes; // 개발자 악수상태
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     *
     *
     * 1. 입력
     *      N : 개발자 인원수
     *      K : 최대 k번 이내의 악수에 대해서만 전염
     *      P : 첫 감염자 번호
     *      T : 악수 횟수
     *      int[] developers : 감염전파자 배열
     *      boolean[] infected : 최종감염상태 배열
     *      Handshake[] handshakes : 악수객체 배열
     *           * 악수객체 => [ T초, 개발자1, 개발자2 ]
     *
     * 2. handshake[]을 T초 기준으로 정렬
     *
     * 3. handshake[]의 각 객체에 대해 :: i 루프
     *      3-1. 두 개발자 중 감염전파자가 있다면
     *          3-1-2. 한 명만 감염전파자라면
     *              감염전파자 감연전파카운트를 --, 비감염자에 k를 삽입, 비감염자 최종감염 상태 표시
     *          3-1-3. 둘 다 감염자라면
     *              둘의 감연전파카운트를 --
     *
     * 4. 최종 감염상태 출력
     */

    static class Handshake implements Comparable {
        int time;
        int developerA;
        int developerB;

        public Handshake(int time, int developerA, int developerB) {
            this.time = time;
            this.developerA = developerA;
            this.developerB = developerB;
        }

        @Override
        public int compareTo(Object o) {
            Handshake h = (Handshake) o;
            return this.time - h.time;
        }
    }

    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt(); // N : 개발자 인원수
        int k = scanner.nextInt(); // K : 최대 k번 이내의 악수에 대해서만 전염
        int p = scanner.nextInt(); // P : 첫 감염자 번호
        int t = scanner.nextInt(); // T : 악수 횟수
        // 감염상태, 악수상태 정의
        developers = new int[n];
        infected = new boolean[n];
        handshakes = new Handshake[t];
        // 악수상태 입력
        for (int i = 0; i < t; i++) {
            int time = scanner.nextInt();
            int devA = scanner.nextInt();
            int devB = scanner.nextInt();
            handshakes[i] = new Handshake(time, devA, devB);
        }
        // 첫 감염자 지정
        developers[p - 1] = k;
        infected[p - 1] = true;

        /* 연산 */
        // 악수 상태 시간 순 정렬
        Arrays.sort(handshakes);
        // 악수 실행
        handShake(n, k, p, t, developers, handshakes);

        /* 출력 */
        printAllInfected(infected);

    }

    private static void printAllInfected(boolean[] infected) {
        for (int i = 0; i < infected.length; i++) {
            if (infected[i] == true)
                System.out.print("1");
            else
                System.out.print("0");
        }
    }

    /*
     * handshake[]의 각 객체에 대해 :: i 루프
     *      3-1. 두 개발자 중 감염자가 있다면
     *          3-1-2. 한 명만 감염자라면
     *              감염자의 감연카운트를 --, 비감염자에 k를 삽입
     *          3-1-3. 둘 다 감염자라면
     *              둘의 감염카운트를 --
     * */
    private static void handShake(int n, int k, int p, int t, int[] developers, Handshake[] handshakes) {
        for (Handshake h : handshakes) {
            // 두 개발자 모두 감염자라면 둘의 감염카운트를 --
            if (developers[h.developerA - 1] > 0 && developers[h.developerB - 1] > 0) {
                developers[h.developerA - 1] -= 1;
                developers[h.developerB - 1] -= 1;
                continue;
            }
            // 개발자 A만 감염자라면 A의 감염카운트 --, B에 k 삽입
            if (developers[h.developerA - 1] > 0 && developers[h.developerB - 1] == 0) {
                developers[h.developerA - 1] -= 1;
                developers[h.developerB - 1] = k;
                infected[h.developerB - 1] = true;
                continue;
            }
            // 개발자 B만 감염자라면 A에 k 삽입, B의 감염카운트 --
            if (developers[h.developerA - 1] == 0 && developers[h.developerB - 1] > 0) {
                developers[h.developerA - 1] = k;
                infected[h.developerA - 1] = true;
                developers[h.developerB - 1] -= 1;
                continue;
            }
        }
    }
}
