package codetree.normal_sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroupOfPairs {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Integer> inputNumList = new LinkedList<>();

    /**
     * 의사코드
     * 1. 그룹의 수 n을 입력받는다.
     *
     * 2. 2 * n 개의 숫자를 입력받아 리스트에 저장한다.
     *
     * 3. 리스트를 오름차순으로 정렬한다. :: O(nlogn)
     *
     * 4. 리스트[k] + 리스트[2*(n-k)] 중 최대값을 찾는다. O(n)
     *      :: < 리스트[k] , 리스트[2*(n-k)] > => 이 한 쌍이 바로 만들 수 있는 그룹
     *      4 - 1. 0 ~ n까지의 인덱스를 순회하며
     *          4 - 1 - a. 합이 이전의 합한 값보다 크다면 최대값 플래그에 저장
     *          4 - 1 - b. 모든 인덱스를 순회하였다면 최대값 플래그 반환
     *
     * 5. 최대값을 출력한다.
     */
    public static void main(String[] args) {

        /* 입력 */
        // 그룹의 수 n을 입력
        int n = scanner.nextInt();
        // 버퍼 비우기
        scanner.nextLine();
        // 2 * n 개의 숫자를 입력받아 리스트에 저장
        storeInputNums(n);


        /* 연산 */
        // 리스트 오름차순 정렬
        inputNumList = sortListByNaturalOrder(inputNumList);
        // 각 쌍이 최소인 그룹으로부터 최대값 찾기
        int max = getMaxGroupOfMin(n, inputNumList);

        /* 출력 */
        System.out.println(max);

    }

    private static int getMaxGroupOfMin(int n, List<Integer> inputNumList) {

        // 최대값 플래그
        int max = 0;
        // 리스트[k] + 리스트[2*(n-k)] 중 최대값을 찾는다
        for (int i = 0; i < n; i++) {
            int sumOfGroup = inputNumList.get(i) + inputNumList.get(2 * n - (i + 1));
            if (sumOfGroup > max)
                max = sumOfGroup;
        }
        return max;
    }

    private static List<Integer> sortListByNaturalOrder(List<Integer> groupOfPairList) {

        // natural order로 스트림 사용한 리스트 정렬
        return inputNumList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private static void storeInputNums(int n) {

        for (int i = 0; i < 2 * n; i++) {
            inputNumList.add(scanner.nextInt());
        }
    }
}
