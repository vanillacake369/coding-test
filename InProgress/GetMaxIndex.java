package InProgress;

import java.util.Arrays;
import java.util.LinkedList;

public class GetMaxIndex {
    public static void main(String[] args) {
        int[] input = {1, 3, 5, 4, 5, 2, 1};

        System.out.println(Arrays.toString(solution(input)));
    }

    public static int[] solution(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] : " + arr[i]);
            if (arr[i] == max) {
                System.out.println("max : " + max);
                list.add(i);
            }
        }
        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}
