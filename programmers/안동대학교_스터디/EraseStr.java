package programmers.안동대학교_스터디;

import java.util.*;

public class EraseStr {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12973
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s) {
        // https://velog.io/@dhk22/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%9D%EC%A7%80%EC%96%B4-%EC%A0%9C%EA%B1%B0%ED%95%98%EA%B8%B0-Java
        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            // 스택이 비어있다면 현재 문자는 반복될 일이 없으므로 push
            if (stack.isEmpty()) stack.push(c);
                // 스택이 비어있지 않다면
            else {
                // 스택의 top확인(peek) - 만약 현재 문자와 같다면 반복이므로 스택에서 pop하고 현재 문자도 스택에 넣지 않음
                // 이렇게 되면 스택에는 반복이 발생하는 이전문자와 현재문자 모두 들어가지 않게 됨 (반복제거)
                if (stack.peek() == c) {
                    stack.pop();
                    // 스택의 top이 현재 문자와 다르다면 반복이 아니므로 push
                } else {
                    stack.push(c);
                }
            }
        }
        // 스택에 남아있는 값들은 반복되지 않는 값들임 즉, 비어있어다면 모두 짝지어 반복된 것
        return stack.isEmpty() ? 1 : 0;
    }

    /*public static int solution(String s) {
        String sTemp = s;
        boolean isDiv = true;
        while (isDiv) {
            for (int i = 0; i < sTemp.length() - 1; i++) {
                if (sTemp.charAt(i) == sTemp.charAt(i + 1)) {
                    // bba...
                    if (i == 0) {
                        sTemp = sTemp.substring(i + 2, sTemp.length() - 1);
                        i = 0;
                        continue;
                    }
                    // ...bba
                    if (i == sTemp.length() - 3) {
                        sTemp = sTemp.substring(0, sTemp.length() - 3);
                        i = 0;
                        continue;
                    }
                    // ...bba...
                    sTemp = sTemp.substring(0, i - 1)
                            + sTemp.substring(i + 2, sTemp.length() - 1);
                    i = 0;
                }
            }
        }
        if (sTemp.equals(""))
            return 1;
        else
            return 0;
    }*/

}
