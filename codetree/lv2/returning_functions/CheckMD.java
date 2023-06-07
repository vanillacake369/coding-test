package codetree.lv2.returning_functions;

import java.util.HashMap;
import java.util.Scanner;

public class CheckMD {
    public static HashMap<Integer, Integer> calender = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        int m = Integer.parseInt(inputStr[0]);
        int d = Integer.parseInt(inputStr[1]);
        // calc
        // 28일
        calender.put(2, 28);
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
        // result
        if (isValidMonthDay(m, d)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    /*
     * 1. hashMap에 월별 최대일수 등록
     * 2. 입력일자가 hashMap 상의 최대일수를 초과하거나 1보다 작은지 체크
     *   2-1. 최대일수를 초과하거나 1보다 작다면 return false
     * */
    private static boolean isValidMonthDay(int m, int d) {
        // hashmap에 없는 키값 지정 시, 최대일수를 0으로 지정하여 무조건 false가 나오게 명세
        int maxDay = calender.getOrDefault(m, 0);
        return (d >= 1) && (d <= maxDay);
    }
}
