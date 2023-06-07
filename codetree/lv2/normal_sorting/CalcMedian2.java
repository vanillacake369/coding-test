package codetree.lv2.normal_sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalcMedian2 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> inputNumList = new LinkedList<>();
    private static List<Integer> medianList = new LinkedList<>();

    /**
     * 의사코드
     * 1. n을 입력받는다.
     * 2. n개의 숫자를 입력받아 리스트에 저장한다.
     * 2-1. 홀수번째 숫자를 입력받을 때마다
     * 2-1-a. 리스트를 오름차순으로 정렬한다.
     * 2-1-b. (int)n/2 번째의 인덱스의 숫자를 최종 중앙값 문자열에 추가한다.
     * 3. 최종 중앙값 문자열을 출력한다.
     */
    public static void main(String[] args) {
        /* 입력 */
        int n = scanner.nextInt();
        // n개의 숫자를 입력받아 리스트에 저장
        addNNumbers(n);

        /* 연산 */
        // 리스트 오름차순 정렬
        sortListInNatural();

        /* 출력 */
        // 0번째 인덱스부터 (int)n/2 번째의 인덱스의 숫자를 출력
        printMedianList();

    }

    private static void printMedianList() {
        for (int median : medianList) {
            System.out.print(median + " ");
        }
    }

    private static void addNNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            // 숫자 입력 & 리스트에 저장
            int input = scanner.nextInt();
            inputNumList.add(input);
            // 홀수번째 숫자를 입력 : 최종문자열에 중앙값 추가
            if (i % 2 != 0)
                getMedian(i);
        }
    }

    private static void getMedian(int i) {
        // 리스트 오름차순 정렬
        sortListInNatural();
        // (int)n/2 번째의 인덱스의 숫자를 최종 중앙값 문자열에 추가한다.
        int median = inputNumList.get(i / 2);
        medianList.add(median);
    }

    private static void sortListInNatural() {
        // natural order로 스트림 사용한 리스트 정렬
        inputNumList = inputNumList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
