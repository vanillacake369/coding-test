package Programmers;

import java.util.Arrays;

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
