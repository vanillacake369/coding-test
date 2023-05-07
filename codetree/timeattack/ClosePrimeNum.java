package codetree.timeattack;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClosePrimeNum {

    private static List<Integer> primeNums = new LinkedList<>();

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     * 1. 숫자를 입력받는다.
     * 2. 숫자와 가까운 소수를 찾는다.
     *      2-1. 숫자 본인이 소수인지 판별한다.
     *          2-1-a. 제곱근만큼의 루프를 돌며 나누어 본다.
     *      2-2. 숫자 - 1이 소수인지 판별한다.
     *      2-3. 숫자 + 1이 소수인지 판별한다.
     *      2-4. 숫자 - 1, 숫자 + 1 소수 판별을 2에 도달할 때까지 한다.
     *      2-5. 만약 두 수 중 하나만 소수인 경우, 해당 소수를 출력한다.
     *      2-6. 만약 두 수 둘 다 소수라면 공백을 사이에 두고 출력한다.
     * */
    public static void main(String[] args) {

        /* 입력 */
        int n = scanner.nextInt();

        /* 연산 */
        getClosestPrimeNum(n);

        /* 출력 */
        for (Integer i : primeNums) {
            System.out.print(i + " ");
        }

    }

    private static void getClosestPrimeNum(int n) {
        /**
         * 2-1. 숫자 본인이 소수인지 판별한다.
         *      2-1-a. 제곱근만큼의 루프를 돌며 나누어 본다.
         * 2-2. 숫자 - 1이 소수인지 판별한다.
         * 2-3. 숫자 + 1이 소수인지 판별한다.
         * 2-4. 숫자 - 1, 숫자 + 1 소수 판별을 2에 도달할 때까지 한다.
         * 2-5. 만약 두 수 중 하나만 소수인 경우, 해당 소수를 출력한다.
         * 2-6. 만약 두 수 둘 다 소수라면 공백을 사이에 두고 출력한다.
         * */

        // 2보다 작은 수가 입력되었다면 가장 가까운 소수는 2
        if (n <= 2) {
            primeNums.add(2);
            return;
        }

        /*// 입력 수 자체가 소수라면 입력 수 자체를 저장
        if (isPrimeNum(n)) {
            primeNums.add(n);
            return;
        }*/


        for (int i = 1; i < n; i++) {

            boolean hasRightClosestPrime = isPrimeNum(n + i);
            boolean hasLeftClosestPrime = isPrimeNum(n - i);

            if (hasLeftClosestPrime && hasRightClosestPrime) {
                primeNums.add(n - i);
                primeNums.add(n + i);
                return;
            }

            if (hasLeftClosestPrime) {
                primeNums.add(n - i);
                return;
            }

            if (hasRightClosestPrime) {
                primeNums.add(n + i);
                return;
            }
        }
    }

    private static boolean isPrimeNum(int n) {

        //  2부터 n의 제곱근까지의 모든 수를 확인하며
        for (int i = 2; i < Math.sqrt(n); i++) {

            // n이 해당 수로 나누어진다면 소수가 아님
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
