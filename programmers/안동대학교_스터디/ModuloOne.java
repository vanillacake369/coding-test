package programmers.안동대학교_스터디;

public class ModuloOne {
    public static void main(String[] args) {

    }

    //     https://school.programmers.co.kr/learn/courses/30/lessons/87389
    public int solution(int n) {
        int answer = 0;
        int result = n - 1;
        answer = result;
        for (int i = 2; i <= (int) Math.sqrt(result) + 1; i++) {
            if (result % i == 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
