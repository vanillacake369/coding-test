package codetree.lv3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BubbleSort {
    // https://www.acmicpc.net/problem/11920

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        /*for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }*/

        // Bubble sort
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(scanner.nextInt());

            if (i >= k)
                System.out.print(pq.poll() + " ");
        }
        /*for (int i = 0; i < k; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }*/

        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
    }
}
