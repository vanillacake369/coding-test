package codetree.lv2.return_recursive;

import java.util.Scanner;

public class MaxUsingRecursive {
    /**
     * 의사코드
     * 1. 첫 번째 줄의 정수 n을 입력받는다.
     * 2.
     * 3.
     */
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* 입력 */
        int n = scanner.nextInt();

        /* 연산 */
        int max = getMax(n, 0);

        /* 출력 */
        System.out.println(max);
    }

    /**
     * 의사코드
     * 1. 마지막까지 입력하면 - 입력된 반복수 n이 1보다 이하라면 - 이전의 최대값을 반환
     * 2. 다음원소 입력
     * 3. 기존값과 비교했을 때 다음 원소가 크다면 다음 원소에 대한 재귀호출
     * 2-1. getMax(n,i)에 --n과 다음원소를 넣어 재귀호출
     * 4. 아니라면 기존원소에 대한 재귀호출
     * 4-1. getMax(n,i)에 --n과 기존값 i를 넣어 재귀호출
     */
    //
    private static int getMax(int n, int i) {
        // 만약 n번째 원소까지 입력받았다면 최대값 반환
        if (n <= 0)
            return i;

        // 다음 원소 입력
        int nextValue = scanner.nextInt();

        // 기존값과 비교했을 때 다음 원소가 크다면 다음 원소에 대한 재귀호출
        if (nextValue > i)
            return getMax(--n, nextValue);
        // 아니라면 기존원소에 대한 재귀호출
        return getMax(--n, i);
    }
}
