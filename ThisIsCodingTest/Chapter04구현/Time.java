package ThisIsCodingTest.Chapter04구현;

import java.util.Scanner;

public class Time {
    // 특정한 시각 안에 '3'이 포함되어 있는지의 여부
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 3시 3분 0초 같은 거는 잡지만
                    // 1시 23분 13초 같은 거는 잡지 않음.
                    // 따라서 3과의 직접적인 비교를 하면 안 됨
                    // 특정 시각 안에 3이 포함되어 있는지를 체크해야함
                    /*
                    if (i == 3 || j == 3 || k == 3) {
                        count++;
                    }*/
                    if (check(i, j, k)) count++;
                }
            }
        }

        System.out.println(count);

    }
}
