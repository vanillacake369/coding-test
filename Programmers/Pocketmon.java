package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Pocketmon {
    public static void main(String[] args) {
        System.out.println("assert that : " + "[3,1,2,3] : " + solution(new int[]{3, 1, 2, 3}));
        System.out.println("assert that : " + "[3,3,3,2,2,4] : " + solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println("assert that : " + "[3,3,3,2,2,2] : " + solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> TypeOfPocketmon = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            TypeOfPocketmon.add(nums[i]);
        }
        int sizeOfTypeOfPocketmon = TypeOfPocketmon.size();
        int maximumExtractCount = (nums.length / 2);
        answer = (sizeOfTypeOfPocketmon > maximumExtractCount) ? maximumExtractCount : sizeOfTypeOfPocketmon;
        return answer;
    }
}
