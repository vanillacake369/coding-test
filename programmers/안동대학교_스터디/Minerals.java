package programmers.안동대학교_스터디;

public class Minerals {
    // https://school.programmers.co.kr/learn/courses/30/lessons/172927

    // https://velog.io/@seowj0710/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%EA%B4%91%EB%AC%BC-%EC%BA%90%EA%B8%B0-Java
    // 나중에 다시 한 번 풀어보기
    public static void main(String[] args) {
        int result = solution(
                new int[]{
                        1, 0, 0
                }, new String[]{
                        "diamond", "diamond"
                }
        );
        System.out.println("result : " + result);
    }


    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int mIndex = 0;

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0)
                continue;
            for (int j = 0; j < picks[i]; j++) {
                for (int k = 0; k < 5; k++) {
                    if (mIndex >= minerals.length)
                        break;
                    answer += getDamage(i, minerals[mIndex]);

                    /*System.out.println("i : " + i);
                    System.out.println("mIndex : " + mIndex);
                    System.out.println("minerals[mIndex] : " + minerals[mIndex]);
                    System.out.println("answer : " + answer);
                    System.out.println("j : " + j);
                    System.out.println("picks[i] : " + picks[i]);*/

                    mIndex++;
                }
            }
        }

        return answer;
    }

    public static int getDamage(int p, String m) {
        int d = 0;
        if (p == 0) {
            if (m.equals("diamond")) {
                d += 1;
            }
            if (m.equals("iron")) {
                d += 1;
            }
            if (m.equals("stone")) {
                d += 1;
            }
        }
        if (p == 1) {
            if (m.equals("diamond")) {
                d += 5;
            }
            if (m.equals("iron")) {
                d += 1;
            }
            if (m.equals("stone")) {
                d += 1;
            }
        }
        if (p == 2) {
            if (m.equals("diamond")) {
                d += 25;
            }
            if (m.equals("iron")) {
                d += 5;
            }
            if (m.equals("stone")) {
                d += 1;
            }
        }
        return d;
    }
}
