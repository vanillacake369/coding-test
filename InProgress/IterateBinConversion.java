package InProgress;

import java.util.Arrays;

public class IterateBinConversion {
    public static void main(String[] args) {
        System.out.println("=== test case 검증 === ");
        System.out.println(" test case 1");
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(" test case 2");
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(" test case 3");
        System.out.println(Arrays.toString(solution("1111111")));
    }

    public static int[] solution(String s) {
        int[] answer = {0, 0};
        String input = s;
        String temp = "";
        int removeCount = 0;
        int removedZeros = 0;
        do {
            temp = "";
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '0') {
                    // filter all the zeros
                    removedZeros++;
                } else if (input.charAt(i) == '1') {
                    temp += input.charAt(i);
                }
            }
//            System.out.println("after trimming zero : " + temp);
            removeCount++;
            // get length of num
            int lengthAfterRemove = temp.length();
            // convert length to binary
            input = Integer.toBinaryString(lengthAfterRemove);

//            System.out.println("after binary conversion : " + temp);
        } while (!temp.equals("1"));
        // iterate until "1"

        // get itertation num and removed zeros num
        answer[0] = removeCount;
        answer[1] = removedZeros;
        return answer;
    }
}
