package InProgress;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LearnMap {
    public static void main(String[] args) {
        // HashTable : sync, but less efficient
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(1, 10);
        table.put(2, 100);
        System.out.println(table);
        System.out.println(table.get(1));
        System.out.println(table.getOrDefault(3, 1000));
        System.out.println(table.keys());
        System.out.println(table.keySet());

        // HashMap : not sync, but more efficient
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 100);
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.getOrDefault(3, 1000));
        System.out.println(map.keySet());

    }
}
