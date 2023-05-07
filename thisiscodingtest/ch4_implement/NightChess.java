package thisiscodingtest.ch4_implement;

import java.util.Hashtable;
import java.util.Scanner;

public class NightChess {
    public static void main(String[] args) {
        Hashtable<Character, Integer> characterIntegerHashtable = new Hashtable<>();
        characterIntegerHashtable.put('a', 1);
        characterIntegerHashtable.put('b', 2);
        characterIntegerHashtable.put('c', 3);
        characterIntegerHashtable.put('d', 4);
        characterIntegerHashtable.put('e', 5);
        characterIntegerHashtable.put('f', 6);
        characterIntegerHashtable.put('g', 7);
        characterIntegerHashtable.put('h', 8);
        String knightXY = new String();

        Scanner scanner = new Scanner(System.in);
        knightXY = scanner.next();

        int knightX = (int) (characterIntegerHashtable.get(knightXY.charAt(0)));
        int knightY = (int) (knightXY.charAt(1) - '0');

        System.out.println("knightX : " + knightX);
        System.out.println("knightY : " + knightY);

        int[] knightMoveX = {-2, -2, +2, +2, +1, -1, +1, -1};
        int[] knightMoveY = {+1, -1, +1, -1, -2, -2, +2, +2};

        int knightMoveCount = 0;
        for (int i = 0; i < knightMoveX.length; i++) {
            int x = (knightX + knightMoveX[i]);
            int y = (knightY + knightMoveY[i]);
            if (x <= 0 || x >= 8 || y <= 0 || y >= 8) {
                continue;
            }
            knightMoveCount++;
        }

        System.out.println(knightMoveCount);

    }
}
