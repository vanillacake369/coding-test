package programmers.안동대학교_스터디;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sort_RemoveMin {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] arr1 = {10};
        int[] answer = solution(arr);
        int[] answer1 = solution(arr1);
        for (int i : answer) {
            System.out.println(" i : " + i);
        }
        for (int i : answer1) {
            System.out.println(" i : " + i);
        }
    }

    public static int[] solution(int[] arr) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int minIndex = 0;
        int minValue = arr[0];
        // find min index & value
        for (int i = 0; i < arr.length; i++) {
            if (minValue >= arr[i]) {
                minIndex = i;
                minValue = arr[i];
            } else {
                continue;
            }
        }
        // remove
        arrList.remove(minIndex);
        if (arrList.size() == 0) {
            arrList.add(-1);
        }
        // convert to array
        return arrList.stream().mapToInt(i -> i).toArray();
    }
}
