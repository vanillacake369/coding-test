package programmers;

import java.util.Arrays;

public class TelephoneDictionary {
    public static void main(String[] args) {
        String[] dictionary = {"119", "97674223", "1195524421"};
        System.out.println("example1 : " + solution(dictionary));
        String[] dictionary2 = {"123", "456", "789"};
        System.out.println("example2 : " + solution(dictionary2));
        String[] dictionary3 = {"12", "123", "1235", "567", "88"};
        System.out.println("example3 : " + solution(dictionary3));
    }

    public static boolean solution(String[] phone_book) {
        /*
        boolean hasNoneDuplicatedNumber = true;
        // O(n^3) : for1차가 n, 2차가 n, 2차 안에서 contains가 n => n^2
        // 각 번호에 관해
        for (int i = 0; i < phone_book.length; i++) {
            int hasContains = 0;
            // 나머지 번호에 대해 비교
            for (int j = i + 1; j < phone_book.length; j++) {
                // 각 문자열에 대해 비교
                if (phone_book[j].contains(phone_book[i])) {
                    hasContains++;
                    break;
                }
            }
            // 나머지 번호가 해당 번호 일부를 하나라도 가지고 있다면 결과값을 토글 후, 반복문 종료
            if (hasContains > 0) {
                hasNoneDuplicatedNumber = false;
                break;
            }
        }
        return hasNoneDuplicatedNumber;
        */


        // O(NlogN) : Tim Sort
        // 사전식 정렬
        Arrays.sort(phone_book);

        // O(N^2) : for(n) * startsWith(n)
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1]))
                return false;
        }

        // 접두사가 없으면 return true
        return true;
    }
}
