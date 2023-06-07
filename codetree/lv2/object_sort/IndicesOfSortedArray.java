package codetree.lv2.object_sort;

import java.util.Arrays;
import java.util.Scanner;

public class IndicesOfSortedArray {

    static class Number implements Comparable<Number> {
        int number;
        int index;

        public Number(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Number b) {
            // number가 작으면 정렬 했을 때 앞에 와야 합니다.
            if (number != b.number)
                return number - b.number;
            // index가 작으면 정렬 했을 때 앞에 와야 합니다.
            return index - b.index;
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    /**
     * 의사코드
     * 1. 값과 기존 인덱스를 가지는 숫자 객체를 통해 값을 입력받는다.
     * 3. 값이 다르면, 값 오름차순으로, 값이 같다면 인덱스 순으로 숫자 객체를 정렬한다.
     * 4. 기존 인덱스 순으로 각각의 숫자 객체를 리스팅한다.
     * 5. 리스팅한 숫자 객체의 값을 출력한다.
     */
    private static final int MAX_NUM = 1000;

    public static void main(String[] args) {

        /* 입력 */
        Number[] numbers = new Number[MAX_NUM];
        int n = sc.nextInt();

        // 값과 기존 인덱스를 가지는 숫자 객체를 통해 값을 입력받는다.
        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(sc.nextInt(), i);
        }

        /* 연산 */
        // 값(혹은 순서)에 따른 정렬
        Arrays.sort(numbers, 0, n);

        // 기존 인덱스에 따른 각 숫자 객체 리스팅
        int[] answer = new int[MAX_NUM];
        for (int i = 0; i < n; i++)
            answer[numbers[i].index] = i + 1;

        /* 출력 */
        // 리스팅한 숫자 객체의 값을 출력한다.
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}