package Codetree.ReturningFunctions;

import java.util.HashMap;
import java.util.Scanner;

public class CheckValidYMD {
    // key : month => value : day
    public static HashMap<Integer, Integer> calender = new HashMap<Integer, Integer>();
    // key : month => value : season
    public static HashMap<Integer, String> season = new HashMap<Integer, String>();

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int y = Integer.parseInt(inputStr[0]);
        int m = Integer.parseInt(inputStr[1]);
        int d = Integer.parseInt(inputStr[2]);
        // calc
        setCalender(y);
        setSeason();
        // result
        String whatSeason = getSeason(m, d);
        System.out.println(whatSeason);
    }

    private static String getSeason(int m, int d) {
        if (validInput(m, d)) {
            return season.get(m);
        } else {
            return "-1";
        }
    }

    private static boolean validInput(int m, int d) {
        // hashmap에 없는 키값 지정 시, 최대일수를 0으로 지정하여 무조건 false가 나오게 명세
        int maxDay = calender.getOrDefault(m, 0);
        return (d >= 1) && (d <= maxDay);
    }

    private static void setSeason() {
        // 봄
        season.put(3, "Spring");
        season.put(4, "Spring");
        season.put(5, "Spring");
        // 여름
        season.put(6, "Summer");
        season.put(7, "Summer");
        season.put(8, "Summer");
        // 가을
        season.put(9, "Fall");
        season.put(10, "Fall");
        season.put(11, "Fall");
        // 겨울
        season.put(12, "Winter");
        season.put(1, "Winter");
        season.put(2, "Winter");
    }

    private static void setCalender(int y) {
        // 28일 or 29일
        if (y % 4 == 0) {
            calender.put(2, 29);
        } else {
            calender.put(2, 28);
        }
        // 31일
        calender.put(1, 31);
        calender.put(3, 31);
        calender.put(5, 31);
        calender.put(7, 31);
        calender.put(8, 31);
        calender.put(10, 31);
        calender.put(12, 31);
        // 30일
        calender.put(4, 30);
        calender.put(6, 30);
        calender.put(9, 30);
        calender.put(11, 30);
    }
}
