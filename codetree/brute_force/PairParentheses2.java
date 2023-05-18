package codetree.brute_force;

import java.util.Scanner;

public class PairParentheses2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static char[] inputList = new char[100];

    public static void main(String[] args) {

        /* 입력 */
        String inputStr = scanner.next();
        int inputLength = inputStr.length();
        for (int i = 0; i < inputStr.length(); i++) {
            inputList[i] = inputStr.charAt(i);
        }

        /* 연산 */
        int countPair = 0;
        for (int i = 0; i < inputLength; i++)
            for (int j = i + 2; j < inputLength; j++)
                if ((inputList[i] == '(') && (inputList[i + 1] == '(')
                        && (inputList[j] == ')') && (inputList[j + 1] == ')'))
                    countPair++;

        /* 출력 */
        System.out.println(countPair);

    }
}
