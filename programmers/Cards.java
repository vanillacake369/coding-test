package programmers;

public class Cards {
    // https://school.programmers.co.kr/learn/courses/30/lessons/159994
    public static void main(String[] args) {
        String answer = solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
//        String answer = solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(answer);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int i1 = 0, i2 = 0;
        boolean isPoss = true;

        for (int i = 0; i < goal.length; i++) {
            String g = goal[i];
            if (i1 != cards1.length && g.equals(cards1[i1])) {
                i1++;
                continue;
            }
            if (i2 != cards2.length && g.equals(cards2[i2])) {
                i2++;
                continue;
            }
            isPoss = false;
            break;
        }

        if (isPoss)
            return "Yes";
        else
            return "No";
    }
}