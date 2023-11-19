package programmers.안동대학교_스터디;

import java.util.Arrays;

public class MissileSystem {
    // 문제링크 https://school.programmers.co.kr/learn/courses/30/lessons/181188
    // 참고해설 https://velog.io/@sheltonwon/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9A%94%EA%B2%A9-%EC%8B%9C%EC%8A%A4%ED%85%9C-JAVA
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        for (int[] target : targets) {
            System.out.println(Arrays.toString(target));
        }

        int last = -1;
        for (int[] target : targets) {
            if (last == -1) {
                answer++;
                last = target[1] - 1;
                System.out.println("===== first last =====");
                System.out.println("answer = " + answer);
                System.out.println("last = " + last);
                continue;
            }

            if (last >= target[0] && last <= target[1]) {
                System.out.println("last is in range of " + target[0] + " and " + target[1]);
                System.out.println("answer = " + answer);
                System.out.println("last = " + last);
                continue;
            }

            answer++;
            last = target[1] - 1;

            System.out.println("answer = " + answer);
            System.out.println("last = " + last);
        }

        return answer;
    }
}
