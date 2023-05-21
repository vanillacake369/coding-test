package codetree.brute_force;

import java.util.*;

public class BeautifulSequence2 {

    private static Set<String> seqBPossibleStrSet = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     *
     * (X) 다음과 같은 테스트 케이스로 인해 실패함
     * > 입력
     *   6 2
     *   5 5 5 5 5 5
     *   5 5
     * > 예상 출력
     *   5
     * > 해당 코드의 출력
     *   1
     *
     * 1. 수열 B를 통해 만들 수 있는 모든 문자열을 생성
     *      :: m * m-1 * m-2 ... => O(m^2)
     * 2. 생성한 모든 경우의 문자열을 셋에 저장
     * 3. 리스트를 순회하며 수열 A가 contains하는지 체크
     *      3-1. 수열 A가 contains한다면 경우의 수 증가
     *       :: O(n)
     * 4. 경우의 수 출력
     */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // flush buffer
        String seqA = scanner.nextLine();
        String seqB = scanner.nextLine();

        /* 연산 */
        // 수열 B에 대한 char 배열
        String[] seqBArr = seqB.split(" ");
        // 수열 B에 대한 모든 경우의 문자열을 생성 후 리스트에 저장
        generatePermutation(seqBArr.length, seqBArr, ' ');
        // 수열 A 내에서 B의 모든 경우의 문자열 찾기
        int caseCount = getCaseCount(seqA);

        /* 출력 */
        System.out.println(caseCount);

    }

    /**
     * 배열 내의 값들로 조합 가능한 모든 경우의 수 생성
     *
     * 1. n-1번째의 원소에 대해 (n-1)!개의 permutaion을 형성
     *      1-1. 이를 재귀호출로서 구현
     *          :: 사이즈가 1이라면 helper 함수인 storePermutatedStr()을 호출하여 Set 구조에 저장
     * 2. n이 홀수라면 first와 last를 swap
     * 3. n이 짝수라면 i번째(i는 0부터 시작하는 카운터)원소와 last를 swap
     *
     * @param n
     * @param elements
     * @param delimiter
     *
     * https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
     * https://www.baeldung.com/java-array-permutations
     */
    public static void generatePermutation(
            int n, String[] elements, char delimiter) {

        if (n == 1) {
            storePermutatedStr(elements, delimiter);
        } else {
            for (int i = 0; i < n - 1; i++) {
                System.out.println("------ INSIDE FOR LOOP ------");
                System.out.println(" n : " + (n - 1) + " , elements : " + elements + " , delimiter : " + delimiter);
                generatePermutation(n - 1, elements, delimiter);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            generatePermutation(n - 1, elements, delimiter);
        }
    }

    /**
     * swap 함수
     * @param elements 입력 배열
     * @param a 바꿀 인덱스 1
     * @param b 바꿀 인덱스 2
     */
    private static void swap(String[] elements, int a, int b) {
        String tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    /**
     * 구분자 없이 생성된 permutation 완료된 배열에 구분자들을 추가 후, 문자열로 변환하여 Set 구조에 저장
     * @param elements permutation 완료한 배열
     * @param delimiter 구분자 (보통 ' ' 입력)
     */
    private static void storePermutatedStr(String[] elements, char delimiter) {
        String permutatedStr = "";
        String delimiterSpace = delimiter + "";
        for (int i = 0; i < elements.length; i++) {
            if (i == (elements.length - 1))
                permutatedStr += elements[i];
            else
                permutatedStr += elements[i] + delimiterSpace;
        }
        seqBPossibleStrSet.add(permutatedStr);
    }

    /**
     * 수열 B가 생성해낼 수 있는 모든 문자열에 대해 수열 A가 contains하고 있다면 경우의 수 증가
     *
     * @param seqA 수열 A
     * @return 수열 A가 수열 B의 모든 경우의 문자열 포함여부에 대한 카운트값
     */
    private static int getCaseCount(String seqA) {
        int caseCount = 0;
        for (String bPossibleStr : seqBPossibleStrSet) {
            if (seqA.contains(bPossibleStr))
                caseCount++;
        }
        return caseCount;
    }
}

/**
 * 해설
 *
 * 수열 B를 정렬한 뒤, 
 * 수열 A의 모든 수에 대해
 * 수열 B의 크기만큼의 리스트를 추출한 뒤, 정렬
 * 추출된 정렬된 리스트와 정렬된 수열 B가 같다면 경우의 수 증가
 *
 * int cnt = 0;
 * for(int i = 0; i <= n - m; i++) {
 *     for(int j = 0; j < m; j++)
 *         tmp[j] = arr1[i + j];
 *     Arrays.sort(tmp, 0, m);
 *
 *     boolean issame = true;
 *     for(int j = 0; j < m; j++)
 *         if(tmp[j] != arr2[j]) {
 *             issame = false;
 *             break;
 *         }
 *
 *     if(issame)
 *         cnt++;
 * }
 */
