package codetree.returning_functions;

import java.util.Scanner;

public class GetPerfectNumber {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputStr[0]);
        int b = Integer.parseInt(inputStr[1]);
        // calc
        int count = getPerfectNumCount(a, b);
        // result
        System.out.println(count);
    }

    private static int getPerfectNumCount(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (hasPerfectNum(i))
                count++;
        }
        return count;
    }

    private static boolean hasPerfectNum(int i) {
        boolean isPerfectNum = true;
        if (i % 2 == 0) {
            return false;
        }
        if (getUnitOf(i) == 5) {
            return false;
        }
        if ((i % 3 == 0) && (i % 9 != 0)) {
            return false;
        }
        return isPerfectNum;
    }

    private static int getUnitOf(int i) {
        String iStr = Integer.toString(i);
        int unit = iStr.charAt(iStr.length() - 1) - '0';
        return unit;
    }
}
