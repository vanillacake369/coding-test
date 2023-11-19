package programmers.안동대학교_스터디;

import java.util.*;
import java.util.stream.Collectors;

public class Boat {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42885
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
