package programmers.안동대학교_스터디;

import java.util.*;

public class IncompletedMarathon {
    public static void main(String[] args) {
        System.out.println("assert that : " + "leo : " + solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        /*
        String answer = null;
        // Hashtable of name(key)=>count(value)
        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();
        // for each participant's name { participant's name(key) => count++(value) }
        for (String name : participant) {
            int count = (stringIntegerHashtable.get(name) == null) ? 0 : stringIntegerHashtable.get(name);
            stringIntegerHashtable.put(name, ++count);
        }
        // for each completion's name { participnat's name(key) => count-- }
        for (String winnerName : completion) {
            int winnerCount = (stringIntegerHashtable.get(winnerName) == null) ? 0 : stringIntegerHashtable.get(winnerName);
            stringIntegerHashtable.put(winnerName, --winnerCount);
        }
        // get existed participant's name
        return stringIntegerHashtable.keySet().iterator().next();
        */
        Map<String, Integer> player = new HashMap<>();
        for (String p : participant) {
            player.put(p, player.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int n = player.get(c) - 1; // completion's name(key) => --count(value)
            if (n == 0) player.remove(c); // if there is completed, remove
            else player.put(c, n); // if there is in-completed, put into HashMap
        }

        return player.keySet().iterator().next(); // get existed key of HashMap
    }
}
