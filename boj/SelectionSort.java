package boj;

import java.util.*;

public class SelectionSort {
    // 문제링크 https://www.acmicpc.net/problem/23882
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = selectionSort(arr, n, k);

        if (result != -1) {
            for (int e : arr)
                System.out.print(e + " ");
        } else {
            System.out.println(result);
        }
    }

    private static int selectionSort(int[] arr, int n, int k) {
        int swapCount = 0;

        for (int i = n - 1; i >= 1; i--) {
            int max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[max])
                    max = j;
            }

            if (max != i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
                swapCount += 1;
            }

            if (swapCount == k)
                return k;
        }

        return -1;
    }
}
