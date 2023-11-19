package programmers.안동대학교_스터디;

import java.util.*;

public class PrivateInfoDuration {
    // https://school.programmers.co.kr/learn/courses/30/lessons/150370
    public static void main(String[] args) {
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] result = solution(today, terms, privacies);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        // calc Today
        String[] tArr = today.split("[.]");
        int tY = Integer.parseInt(tArr[0]);
        int tM = Integer.parseInt(tArr[1]);
        int tD = Integer.parseInt(tArr[2]);
        int tSum = (tY - 2000) * 12 * 28
                + tM * 28
                + tD;
        // terms :: 해쉬테이블
        Hashtable<String, Integer> termT = new Hashtable<>();
        for (String t : terms) {
            String[] termArr = t.split(" ");
            termT.put(
                    termArr[0],
                    Integer.parseInt(termArr[1])
            );
        }
        // 각 수집일 유효기간 - 오늘 <= 0 이라면 유효기간초과일
        List<Integer> rList = new ArrayList();
        for (int i = 0; i < privacies.length; i++) {
            int pY = Integer.parseInt(privacies[i].substring(0, 4));
            int pM = Integer.parseInt(privacies[i].substring(5, 7));
            int pD = Integer.parseInt(privacies[i].substring(8, 10));
            String pT = privacies[i].split(" ")[1];
            int pSum = (pY - 2000) * 12 * 28
                    + pM * 28
                    + pD
                    + termT.get(pT) * 28;

            if (pSum - tSum <= 0) {
                rList.add(i + 1);
            }
        }

        return rList.stream().mapToInt(Integer::intValue).toArray();
    }
}
