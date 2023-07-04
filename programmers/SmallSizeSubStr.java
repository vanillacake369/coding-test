package programmers;

public class SmallSizeSubStr {
    // https://school.programmers.co.kr/learn/courses/30/lessons/147355
    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        int l = p.length();
        Long pI = Long.parseLong(p);
        for (int i = 0; i + l <= t.length(); i++) {
            String sub = t.substring(i, i + l);
            if (Long.parseLong(sub) <= pI) {
                answer++;
            }
        }
        return answer;
    }
}
