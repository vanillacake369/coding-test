package programmers;

public class LeagueTable {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12985
    // https://ilmiodiario.tistory.com/121
    public static void main(String[] args) {
        // System.out.println(solution(8, 4, 7));
        System.out.println(solution(8, 4, 5));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        int rA = a;
        int rB = b;
        /*while (Math.abs(rA - rB) != 1) {
            answer++;
            if (rA % 2 == 0) {
                rA /= 2;
            } else {
                rA = rA / 2 + 1;
            }
            if (rB % 2 == 0) {
                rB /= 2;
            } else {
                rB = rB / 2 + 1;
            }
        }*/

        while (true) {
            rA = rA / 2 + rA % 2;
            rB = rB / 2 + rB % 2;
            answer++;
            if (rA == rB)
                break;
        }

        return answer;
    }

}
