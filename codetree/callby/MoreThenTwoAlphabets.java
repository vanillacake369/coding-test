package codetree.callby;

import java.util.HashMap;
import java.util.Scanner;

public class MoreThenTwoAlphabets {
    private static final HashMap<Character, Integer> dictionary = new HashMap<>();

    public static void main(String[] args) {
        /*
         * 1. get input str
         * 2. convert input str to array
         * 3. get each element of each index
         * 4. create hashmap 'dictionary'
         * 5. insert each element into dictionary
         * 6. check if dictionary length
         *      6-1. if dictionary length >= 2
         *          6-1-a. print "Yes"
         *      6-2. else
         *          6-2-a. print "No"
         * */
        /* input */
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        /* calc */
        /* result */
        if (hasMoreThanTwoAlphabets(inputStr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean hasMoreThanTwoAlphabets(String inputStr) {
        // 문자열 입력 오류 예외처리
        if (!(inputStr.length() > 0)) {
            return false;
        }
        // 3. get each element of each index
        for (int i = 0; i < inputStr.length(); i++) {
            Character eachElement = inputStr.charAt(i);
            // 5. update if present (이 방법말고도 Java8문법 사용한 방법도 많음요)
            dictionary.merge(eachElement, 1, Integer::sum);
        }
        // 6. check dictionary length
        return dictionary.size() >= 2;
    }
}
