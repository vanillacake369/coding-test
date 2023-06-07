package codetree.lv2.returning_functions;

import java.util.Scanner;

public class CheckContinuousSubsequence {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(inputStr[0]);
        int n2 = Integer.parseInt(inputStr[1]);
        String[] ArrayA = scanner.nextLine().split(" ");
        String[] ArrayB = scanner.nextLine().split(" ");
        // calc
        // result
        if (isPartOfArray(ArrayA, ArrayB)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    /*
            1. find B's first element from A
                1-1. if A has not B's first element
                    1-1.a return false;
            2. check next element of B and A
                2-1. if B's next element != A's next element
                    2-1.a return false;
                2-2. if B's next element == A's next element
                    2-2.a continue;
            3. loop step 2 until B's last element
            * */
    private static boolean isPartOfArray(String[] arrayA, String[] arrayB) {
        int pointerB = 0, pointerA = 0;
        // find index of A where is B's first element
        pointerA = getPointerA(arrayA, pointerA, arrayB[pointerB]);
        // check next element of B and A
        while (pointerB < arrayB.length) {
            // get next element
            String nextElementOfB = arrayB[pointerB++];
            String nextElementOfA = arrayA[pointerA++];
            // if next element not equal, then return false
            if (!nextElementOfB.equals(nextElementOfA)) {
                return false;
            }
            // loop until B's last element
        }
        return true;
    }

    private static int getPointerA(String[] arrayA, int pointerA, String arrayB) {
        String firstElement = arrayB;
        for (int i = 0; i < arrayA.length; i++) {
            if (firstElement.equals(arrayA[i])) {
                return i;
            }
        }
        return pointerA;
    }
}
