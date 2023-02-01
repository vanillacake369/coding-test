package InProgress;

public class Sort_JadenCase {
    public static void main(String[] args) {
        System.out.println("exmple 1 : " + solution("3people unFollowed me"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // 공백 구분자로 문자열 구분 => String[]
        String[] jaden = s.split(" ");
        // 정답문자열 = 첫문자 (=>대문자) + 나머지 문자 (=>소문자) + 공백
        for (int i = 0; i < jaden.length; i++) {
            String str = jaden[i];
            String space = (i != jaden.length - 1) ? " " : "";

            sb.append((str.charAt(0) + "").toUpperCase()
                    + str.substring(1).toLowerCase() + space);
        }
        return sb.toString();
    }
}
