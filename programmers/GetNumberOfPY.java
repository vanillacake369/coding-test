package programmers;

public class GetNumberOfPY {
    public static void main(String[] args) {
        String example1 = "pPoooyY";
        System.out.println("example1 : " + solution(example1));
        String example2 = "Pyy";
        System.out.println("example2 : " + solution(example2));
    }

    public static boolean solution(String s) {
        // #1  HashTable 사용하기 :: P,p / Y,y (key) => Count(value)
        // O(N)
        /*
        boolean answer = true;
        char[] arr = s.toCharArray();
        Hashtable<Character, Integer> characterIntegerHashtable = new Hashtable<>();
        for (char c : arr) {
            if (c == 'P' || c == 'p') {
                characterIntegerHashtable.put('p', (characterIntegerHashtable.getOrDefault('p', 0) + 1));
            } else if (c == 'Y' || c == 'y') {
                characterIntegerHashtable.put('y', (characterIntegerHashtable.getOrDefault('y', 0) + 1));
            }
        }

        if (characterIntegerHashtable.get('p') == characterIntegerHashtable.get('y')) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
         */

        // #2 대문자를 없애기
        // O(N)
        /*
        String s2 = s.toLowerCase();
        int p = 0;
        for (char c : s2.toCharArray()) if (c == 'p') p++;
        for (char c : s2.toCharArray()) if (c == 'y') p--;
        return (p == 0);

         */
        // #3 정규표현식 사용하기
        // O(N)
        int p = s.replaceAll("[^pP]", "").length();
        int y = s.replaceAll("[^yY]", "").length();
        return (p == y);
    }
}
