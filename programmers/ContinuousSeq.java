package programmers;

import java.util.*;

public class ContinuousSeq {
    // https://school.programmers.co.kr/learn/courses/30/lessons/178870
    static ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};

        // sequence에서 합이 k인 연속 부분 수열의 모든 집합 구하기
        getAllSeqSet(sequence, k);

        // 연속 부분 수열 집합 로그
        for (ArrayList<Integer> list : answerList) {
            System.out.println(list.toString());
        }

        // 연속 부분 수열 집합에서 길이가 같은지 검증
        boolean isSameLength = true;
        if (answerList.size() > 0) {
            int sameLength = answerList.get(0).get(1) - answerList.get(0).get(0);
            for (ArrayList<Integer> list : answerList) {
                int length = (list.get(1) - list.get(0));
                if (length != sameLength) {
                    isSameLength = false;
                    break;
                }
            }
        }

        System.out.println("isSameLength : " + isSameLength);

        // 연속 부분 수열 집합에서 길이가 모두 같다면 가장 앞쪽에 나오는 수열을 찾기
        if (isSameLength) {
            answer[0] = answerList.get(0).get(0);
            answer[1] = answerList.get(0).get(1);
        }
        // 연속 부분 수열 집합에서 길이가 모두 다르다면 가장 짧은 길이의 수열을 찾기
        else {
            int minDiff = 1000000;
            for (ArrayList<Integer> list : answerList) {
                int diff = list.get(1) - list.get(0);
                if (diff == Math.min(minDiff, diff)) {
                    answer[0] = list.get(0);
                    answer[1] = list.get(1);
                }
            }
        }

        return answer;
    }

    public static void getAllSeqSet(int[] sequence, int k) {
        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum == k) {
                    ArrayList<Integer> answer = new ArrayList<>();
                    answer.add(i);
                    answer.add(j);
                    answerList.add(answer);
                    break;
                }
            }
        }
    }
}