package Codetree.NormalSorting;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/* 두 개의 동일한 수열 */
public class SameTwoProgression {
    public static Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    /** 의사 코드
     * 1. 수열의 크기를 입력으로 받는다.
     * 1. 두번째 줄의 모든 값을 - 첫 번째 수열을 -  해쉬테이블에 저장한다. <값 : 등장수 >
     * 2. 세번째 줄의 모든 값을 - 두 번째 수열을 - 비교한다.
     *  2-1. 모든 값이 키 값으로 등록되어있다면 Yes
     *  2-2. 이외의 경우 No 반환
     * */

    /**
     * 이렇게 구현한 이유
     * > 이 방법이 더 빠르다고 생각되어서이다.
     * > 중복되는 원소가 없으므로 해쉬테이블을 사용해도 무관하다.
     * > 물론 BigO로 본다면 두 방법 모두 O(n)으로 수렴하지만
     * > 방법2는 입력과 동시에 비교가능하므로 더 빠르다.
     * <p>
     * > # 방법 1
     * > 1)모든 수를 입력받아 수열 리스트 생성 :: O(n)
     * > 2)두 수열 리스트를 정렬하여 :: O(nlogn)
     * > 3)각 인덱스를 하나하나 비교하기 :: O(n)
     * <p>
     * > # 방법 2
     * > 1) 두 번째 줄을 - 첫 수열을 - 입력할 때마다 해쉬테이블로 저장 :: O(n)
     * > 2) 세 번째 줄을 - 두 번째 수열을 - 입력받자마자 해쉬테이블에서 찾기 :: O(1)
     */
    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);

        /* 연산 */
        scanner.nextLine(); // 해당 로직 프로세스 상 수열의 크기 입력은 의미가 없으므로 그냥 받기만 하고 저장하지 않음
        String resultOfComparison = compareTwoProgression(scanner); // 두 수열이 같다면 Yes,아니라면 No 반환 함수 호출

        /* 출력 */
        System.out.println(resultOfComparison);
    }

    /**
     * 의사코드
     * 첫 수열 :: 각 숫자를 " " 구분자를 통해 정수형 배열로서 입력받기
     * 첫 수열을 해쉬테이블에 저장 :: <값 : 등장수>
     * 기존값이 있다면 +1
     * 두 번째 수열 :: 각 숫자를 " " 구분자를 통해 정수형 배열로서 입력받기
     * 두 수열을 비교 :: 두 수열이 같다면 true, 아니라면 false
     */
    private static String compareTwoProgression(Scanner scanner) {

        // 첫 수열 :: 각 숫자를 " " 구분자를 통해 정수형 배열로서 입력받기 
        int[] firstProgression = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        // 첫 수열을 해쉬테이블에 저장 :: <값 : 등장수>
        for (int element : firstProgression) {
            hashtable.put(element, 1);
        }

        // 두 번째 수열 :: 각 숫자를 " " 구분자를 통해 정수형 배열로서 입력받기
        int[] secondProgression = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        // 두 수열을 비교 :: 두 수열이 같다면 true, 아니라면 false
        if (hasHashTableKey(secondProgression)) {
            return "Yes";
        }
        return "No";
    }

    /**
     * 입력된 배열의 원소 중에서 해쉬테이블에 키값으로 등록되어있지않다면 false 반환
     *
     * @param secondProgression
     * @return boolean
     */
    private static boolean hasHashTableKey(int[] secondProgression) {
        for (int element : secondProgression) {
            // 키 값이 존재하지 않다면
            if (!hashtable.containsKey(element)) {
                return false;
            }
        }

        return true;
    }
}