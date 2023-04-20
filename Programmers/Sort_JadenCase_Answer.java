package Programmers;

public class Sort_JadenCase_Answer {
    public static String solution(String s) {
//        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 문자열 전체를 소문자로 변환
        String s2 = s.toLowerCase();
        char last = ' ';
        // 이전 문자가 공백이었다면 현재 문자를 대문자로 변환, 변환 이후 answer문자열에 추가
        for (char c : s2.toCharArray()) {
            if (last == ' ') c = Character.toUpperCase(c);
//         문자열에 새로운 문자열 추가 :: String을 새로 만들어냄 => 메모리 효율 떨어짐
//            answer += c;
//         StringBuilder 사용 :: StringBuilder 안에 있는 버퍼에 추가, toString() 호출 시 버퍼 종료
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }
}
