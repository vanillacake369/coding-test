package programmers.안동대학교_스터디;

import java.util.Arrays;

// Arrays.sort()(:: int[]), Collections.sort()(:: List<Integer>
// Collections.sort()는 내부적으로 Arrays.sort()를 사용함!
public class MakeMinimum {
    public static void main(String[] args) {
        int min = solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        System.out.println("Min : " + min);
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        int[] AscA = A;
        /* int[] DescB = Arrays.stream(B)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray(); */
        Arrays.sort(B);
        int[] AscB = B;
        // A의 최대 x B의 최소
        for (int i = 0; i < A.length; i++) {
            answer += (AscA[i] * AscB[B.length - 1 - i]);
        }
        return answer;
    }
}
