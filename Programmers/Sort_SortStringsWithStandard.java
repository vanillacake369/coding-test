package Programmers;

import java.util.Arrays;

public class Sort_SortStringsWithStandard {
    public static void main(String[] args) {
        String[] an = solution(new String[]{"sun", "bed", "car"}, 1);
        Arrays.stream(an).forEach(System.out::println);
        String[] an1 = solution(new String[]{"abce", "abcd", "cdx"}, 2);
        Arrays.stream(an1).forEach(System.out::println);
    }
    /* 정답
    class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings,(s1,s2)->{
                if(s1.charAt(n) == s2.charAt(n)){
                    return s1.compareTo(s2);
                }
                return s1.charAt(n) - s2.charAt(n);
            });
            return strings;
        }
    }*/

    public static String[] solution(String[] strings, int n) {
        DicStr[] dicStrs = new DicStr[strings.length];
        int index = n;
        for (int i = 0; i < dicStrs.length; i++) {
            DicStr d = new DicStr();
            d.setS(strings[i]);
            d.setIndex(index);
            dicStrs[i] = d;
        }
        return Arrays.stream(dicStrs).sorted().map(DicStr::getS).toArray(String[]::new);
    }
}

class DicStr implements Comparable<DicStr> {
    String s;
    int index;

    public String getS() {
        return s;
    }

    public int getIndex() {
        return index;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(DicStr o) {
        int i = index;
        for (i = index; i < o.getS().length(); i++) {
            if (getS().charAt(i) == o.getS().charAt(i)) {
                continue;
            } else {
                break;
            }
        }
        return (getS().charAt(i) - o.getS().charAt(i));
    }
}