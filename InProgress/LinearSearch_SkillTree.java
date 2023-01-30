package InProgress;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch_SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println("example1 : " + solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        // 큐 생성
        List<String> skillQueue = new ArrayList<>();
        // 큐에 대한 포인터
        int index = 0;
        // 맞는 스킬트리 count
        int possibleSkillTree = 0;

        // 스킬들(skill) 속 스킬 하나하나 => 큐
        for (int i = 0; i < skill.length(); i++) {
            skillQueue.add(Character.toString(skill.charAt(i)));
        }
        // 스킬 트리 속 스킬과 스킬 비교 :: 스킬 일치 시 포인터 이동
        for (int i = 0; i < skill_trees.length; i++) {
            String skills = skill_trees[i];
            String s = null;
            for (int j = 0; j < skills.length(); j++) {
                String seq = skillQueue.get(index);
                System.out.println("seq : " + seq);
                s = Character.toString(skills.charAt(j));
                System.out.println("s : " + s);
                if ((index < skillQueue.size()) && (seq.equals(s))) {
                    System.out.println("match : " + s + " and " + seq);
                    ++index;
                    System.out.println("index : " + index);
                }
                // 포인터가 끝까지 이동 => 스킬트리 개수 count
                else if (index >= skillQueue.size()) {
                    ++possibleSkillTree;
                }
            }

            // 포인터 초기화
            index = 0;
            System.out.println("count possible tree : " + possibleSkillTree);
        }

        return possibleSkillTree;
    }
}
