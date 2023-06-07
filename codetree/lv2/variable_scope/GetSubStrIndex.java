package codetree.lv2.variable_scope;

import java.util.Scanner;

public class GetSubStrIndex {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String destStr = scanner.nextLine();
        String subStr = scanner.nextLine();
        // calc
        int index = findIndexOfSubStr(destStr, subStr);
        // result
        System.out.println(index);
    }

    private static int findIndexOfSubStr(String destStr, String subStr) {
        return destStr.indexOf(subStr);
    }
}
