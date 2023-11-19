package programmers.안동대학교_스터디;
//https://school.programmers.co.kr/learn/courses/30/lessons/160586

import java.sql.SQLOutput;
import java.util.Hashtable;

public class Keyboard {
    public static void main(String[] args) {
//        int[] answer = solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
//        int[] answer = solution(new String[]{"AA"}, new String[]{"B"});
//        int[] answer = solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"});
//        int[] answer = solution(new String[]{"ABCE"}, new String[]{"ABDE"});
//        for (int a : answer) {
//            System.out.println(a);
//        }
    }

    public int[] solution(String[] keymap, String[] targets) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (String k : keymap) {
            for (int i = 0; i < k.length(); i++) {
                char ch = k.charAt(i);
                if (table.get(ch) != null) {
                    table.put(
                            ch,
                            Math.min(table.get(ch), i + 1)
                    );
                } else {
                    table.put(ch, i + 1);
                }
            }
        }
        int[] arr = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if (table.get(ch) == null) {
                    sum = -1;
                    break;
                } else {
                    sum += table.get(ch);
                }
            }
            arr[i] = sum;
        }
        return arr;
    }
}
