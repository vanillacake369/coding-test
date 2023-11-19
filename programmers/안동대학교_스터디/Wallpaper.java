package programmers.안동대학교_스터디;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Wallpaper {
    public static void main(String[] args) {
        int[] answer = solution(new String[]{".#...", "..#..", "...#."});
        int[] answer1 = solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
        int[] answer2 = solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        int[] answer3 = solution(new String[]{"..", "#."});
        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
        System.out.println(Arrays.toString(answer3));
    }

    public static int[] solution(String[] wallpaper) {
        // row1=min row, col1=min col, row2=max row+1, col2=max col+1
        int row1 = 51, col1 = 51, row2 = 0, col2 = 0;

        for (int i = 0; i < wallpaper.length; i++) { // i:row
            String data = wallpaper[i];
            for (int j = 0; j < data.length(); j++) { // j:col
                if (data.charAt(j) == '#') {
                    row1 = Math.min(row1, i);
                    col1 = Math.min(col1, j);
                    row2 = Math.max(row2, i);
                    col2 = Math.max(col2, j);
                }
            }
        }

        row2 += 1;
        col2 += 1;

        return new int[]{row1, col1, row2, col2};
    }
}
