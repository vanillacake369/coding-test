package codetree.lv2.normal_sorting;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class DetermineSameWord {

    private static final Scanner scanner = new Scanner(System.in);

    // 첫 번째 문자열에 대한 해쉬테이블과 해쉬셋
    private static Hashtable<Integer, Integer> firstStrTable = new Hashtable<>();
    private static HashSet<Integer> firstStrSet = new HashSet<>();
    // 두 번째 문자열에 대한 해쉬테이블
    private static Hashtable<Integer, Integer> secondStrTable = new Hashtable<>();

    /*
     * 다른 방법 :: 문자열 정렬 후 비교 => 2 * O(nlogn) + O(n)
     * 1. 첫 번째 문자열을 입력받는다.
     * 2. 첫 번째 문자열을 리스트로 변환한다.
     * 3. 첫 번째 문자열 리스트를 정렬한다. => O(nlogn)
     * 4. 두 번째 문자열을 입력받는다.
     * 5. 두 번째 문자열을 리스트로 변환한다.
     * 6. 두 번째 문자열 리스트를 정렬한다. => O(nlogn)
     * 7. 두 리스트가 서로 같은 원소를 가지고 있는지 검증한다. => O(n)
     */

    /**
     * 의사코드 => O(1)
     * 1. 첫 번째 문자열에 대한 해쉬테이블과 해쉬셋을 만든다.
     *      1 - 1. 이 때, 해쉬테이블은 < key : value >로서 < 각 문자 : 등장수 >의 값을 가짐
     * 2. 두 번째 문자열에 대한 해쉬테이블을 만든다.
     * 3. 해쉬셋의 각 원소에 대해 각 문자열 해쉬테이블을 사용하여 두 문자열의 등장수를 비교한다. => O(1)
     */
    public static void main(String[] args) {

        /* 입력 */
        String firstStr = scanner.nextLine();
        String secondStr = scanner.nextLine();

        /* 연산 */
        if (firstStr.length() != secondStr.length()) {
            System.out.println("No");
            return;
        }
        firstStrTable = makeStrTable(firstStr, firstStrTable);
        firstStrSet = makeFirstStrSet(firstStr, firstStrSet);
        secondStrTable = makeStrTable(secondStr, secondStrTable);
        boolean isSameCombination = hasSameCombination(firstStrSet, firstStrTable, secondStrTable);

        /* 출력 */
        printResult(isSameCombination);

    }

    private static void printResult(boolean isSameCombination) {
        if (isSameCombination) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }

    private static boolean hasSameCombination(HashSet<Integer> firstStrSet, Hashtable<Integer, Integer> firstStrTable, Hashtable<Integer, Integer> secondStrTable) {
        for (Integer alphabet : firstStrSet) {
            int firstStrApperance = firstStrTable.getOrDefault(alphabet, 0);
            int secondStrApperance = secondStrTable.getOrDefault(alphabet, 0);
            if (firstStrApperance != secondStrApperance)
                return false;
        }
        return true;
    }

    private static HashSet<Integer> makeFirstStrSet(String firstStr, HashSet<Integer> firstStrSet) {
        for (int i = 0; i < firstStr.length(); i++) {
            firstStrSet.add((int) firstStr.charAt(i));
        }
        return firstStrSet;
    }

    private static Hashtable<Integer, Integer> makeStrTable(String str, Hashtable<Integer, Integer> strTable) {
        for (int i = 0; i < str.length(); i++) {
            int eachChar = str.charAt(i);
            strTable.put(eachChar, strTable.getOrDefault(eachChar, 0) + 1);
        }
        return strTable;
    }
}
