package codetree.brute_force_1;

import java.util.Scanner;

public class PairParentheses3 {

    // 스캐너 객체
    private static final Scanner scanner = new Scanner(System.in);
    // 입력 문자열 최대 개수
    private static final int MAX_INPUT_SIZE = 100;
    // 입력 문자열 리스트
    private static char[] inputs = new char[MAX_INPUT_SIZE];
    // 조합의 개수
    private static int combiCount = 0;


    /**
     * 의사코드
     *
     * " 특정 조건에 따른 값을 추출하는 모든 경우의 수 중에 최대/최소값 "
     * => 완전탐색
     *
     * 1. '('을 찾는다.
     * 2. 다음 ')'과 조합의 개수를 카운트한다.
     * 3. 모든 '('에 대해 조합의 개수를 카운트하였다면 조합 찾기를 중단한다.
     * 4. 조합의 개수를 출력한다.
     */
    public static void main(String[] args) {

        /* 입력 */
        String inputStr = scanner.next();
        for (int i = 0; i < inputStr.length(); i++) {
            inputs[i] = inputStr.charAt(i);
        }

        /* 연산 */
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputs[i] == '(') {
                for (int j = i + 1; j < inputStr.length(); j++) {
                    if (inputs[j] == ')') {
                        combiCount++;
                    }
                }
            }
        }

        /* 출력 */
        System.out.println(combiCount);
    }
}
