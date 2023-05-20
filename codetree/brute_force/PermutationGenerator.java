package codetree.brute_force;

import java.util.HashSet;
import java.util.Set;

public class PermutationGenerator {
    public static <Integer> void printAllRecursive(
            int n, int[] elements, char delimiter) {

        if (n == 1) {
            printArray(elements, delimiter);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }

    private static void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private static void printArray(int[] elements, char delimiter) {
        String delimiterSpace = delimiter + " ";
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 4};
        printAllRecursive(arr.length, arr, ' ');
    }
}