package Programmers;

public class Pibonachi {
    public static void main(String[] args) {
        // # Method 1
        // Test Case 1
        System.out.println("3에 대한 예상결과 : " + 2 + "-> 결과값은 : " + solution(3));
        // Test Case 2
        System.out.println("5에 대한 예상결과 : " + 5 + "-> 결과값은 : " + solution(5));
        // # Method 2 :: StackOverflowError 발생
        // Test Case 1
        System.out.println("3에 대한 예상결과 : " + 2 + "-> 결과값은 : " + solution2(3));
        // Test Case 2
        System.out.println("5에 대한 예상결과 : " + 5 + "-> 결과값은 : " + solution2(5));
        // # Method 3
        /*// Test Case 1
        System.out.println("3에 대한 예상결과 : " + 2 + "-> 결과값은 : " + solution3(3));
        // Test Case 2
        System.out.println("5에 대한 예상결과 : " + 5 + "-> 결과값은 : " + solution3(5));*/

    }

    // # 1. 재귀 함수
    /*
    0이면 0을 리턴, 1이면 1을 리턴
    0이나 1이 될 때까지 f(n-1) + f(n-2)을 호출
    */
    public static int solution(int n) {
        int answer = 0;
        // recursive call
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            answer = (solution(n - 1) + solution(n - 2)) % 1234567;
        }
        return answer;
    }

    // # 2. 패턴 학습
    /*
    f(n) = f(n/2) + 2f(n-3) + f(n-2)
    이것도 결국 재귀이지만, n/2를 통해 호출횟수를 반으로 줄일 수 있다는 점에서
    괜찮은 것 같다.
    */
    public static int solution2(int n) {
        int answer = 0;
        // recursive call
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            answer = solution2(n - 4) + 2 * solution2(n - 3) + solution2(n - 2);
        }
        // do mod 1234567
        return (answer % 1234567);
    }

    // # 3.
    public static int solution3(int n) {
        int answer = 0;
        // recursive call
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            answer = solution(n - 1) + solution(n - 2);
        }
        // do mod 1234567
        return (answer % 1234567);
    }
}
