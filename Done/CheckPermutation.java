package Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckPermutation {
    public static void main(String[] args) {
        int[] testArr1 = {4, 1, 3, 2};
        int[] testArr2 = {4, 1, 3};
        System.out.println("test case1 : " + solution(testArr1));
        System.out.println("test case2 : " + solution(testArr2));
    }

    public static boolean solution(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) answer[i] = i + 1;
        Arrays.sort(arr);
        return Arrays.equals(answer, arr);
    }
}
