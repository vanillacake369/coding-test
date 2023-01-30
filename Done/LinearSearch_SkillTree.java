package Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class LinearSearch_SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println("example1 : " + solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        // 정규화 :: Stream 사용
        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(s -> skill.startsWith(s))
                .count();
        // 정규화 :: for문 사용
        /*int answer = 0;
        for (String s : skill_trees) {
            String s2 = s.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(s2)) answer++;
        }
        return answer;*/


        /*// 해시테이블 생성
        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();
        // 포인터
        int index = 0;
        // 맞는 스킬트리 count
        int possibleSkillTree = 0;

        // 스킬들(skill) 속 스킬 하나하나 :: 스킬(key)=>순서(value)
        for (int i = 0; i < skill.length(); i++) {
            String sk = Character.toString(skill.charAt(i));
            stringIntegerHashtable.put(sk, i);
        }

        // 스킬 트리 속 스킬과 스킬 비교 :: 스킬 일치 시 포인터 이동
        for (int i = 0; i < skill_trees.length; i++) {
            if (index >= stringIntegerHashtable.size()) {
                break;
            }
            String skills = skill_trees[i];
            String s = null;
            boolean isPossible = true;
            for (int j = 0; j < skills.length(); j++) {
                s = Character.toString(skills.charAt(j));
                int seq = stringIntegerHashtable.getOrDefault(s, -1);
                if (seq > index) {
                    isPossible = false;
                    break;
                } else if (seq == index) {
                    index++;
                } else {
                    continue;
                }
            }
            if (isPossible == true) {
                possibleSkillTree++;
            } else {
                continue;
            }
            // 포인터 초기화
            index = 0;
        }
        return possibleSkillTree;*/
    }
}