package programmers.안동대학교_스터디;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntegerConversion {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123456)));
        System.out.println(Arrays.toString(solution(5241)));
    }

    public static int[] solution(long n) {
        // 풀이 1
        // Time : O(n)
        // Mem : String(n),List(n)
        /*String input = String.valueOf(n);
        int length = input.length();
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = input.charAt(length - 1 - i) - 48;
        }
        return answer;*/

        // 풀이 2
        // Time : O(n)
        // Mem : List(n)
        List<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.add((int) n % 10);
            n /= 10;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
