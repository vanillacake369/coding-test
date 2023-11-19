package programmers.안동대학교_스터디;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class NextBigNum {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        /*int answer = 0;
        // arr <- 2진수 변환배열
        int[] arr = new int[20];
        int m = n;
        for (int i = 20; i >= 0; i--) {
            if (m / Math.pow(2, i) >= 1) {
                m -= Math.pow(2, i);
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        // 다음 큰 숫자 구하기
        boolean firstBig = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (firstBig && arr[i] == 1 && arr[i - 1] == 0) {
                firstBig = false;
                answer += Math.pow(2, i);
                for (int j = i; j < arr.length; j++) {

                }
            }
        }


        return answer;*/
        int answer = 0;
        // 1. 입력받은 n의 1 개수를 저장.
        int n_cnt = Integer.bitCount(n);
        // 2. 증가하는 n의 1 개수를 저장 할 변수.
        int b_cnt = 0;
        // 3. 무한반복.
        while (true) {
            // 4. n을 증가.
            n++;
            // 5. 증가된 n의 1 개수를 저장.
            b_cnt = Integer.bitCount(n);
            // 6. 일치하면, answer에 n을 담고 반복문을 빠져나온다.
            if (n_cnt == b_cnt) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}
