package Programmers;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class MixingClothes {
    public static void main(String[] args) {
        String[][] example1 = new String[][]
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("assert that : " + solution(example1));
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        int eachWorn = 0;
        int mixWorn = 1;

        // type(key) => count(value)
        Hashtable<String, Integer> typeCount = new Hashtable<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            Integer count = typeCount.getOrDefault(type, 0);
            typeCount.put(type, ++count);
        }

        Iterator<Integer> iterator = typeCount.values().iterator();

        Set<String> keys = typeCount.keySet();
        for (String key : keys) {
            if (keys.size() > 1) {
                eachWorn += typeCount.get(key);
                mixWorn *= typeCount.get(key);
                answer = eachWorn + mixWorn;
            } else {
                eachWorn += typeCount.get(key);
                answer = eachWorn;
            }
        }
        return answer;
    }
}
