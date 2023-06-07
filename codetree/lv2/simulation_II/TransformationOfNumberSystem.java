package codetree.lv2.simulation_II;

import java.util.Scanner;

public class TransformationOfNumberSystem {
    public static void main(String[] args) {

        // Garbage Collection으로 메모리 초기화
        System.gc();

        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();

        // a진수로 주어진 n을 10진수로 변환
        int decimalTransformedNum = 0;
        String strN = Integer.toString(n);
        for (int i = 0; i < strN.length(); i++) {
            int squareNum = strN.length() - i - 1;
            int digit = strN.charAt(i) - '0';
            decimalTransformedNum += digit * Math.pow(a, squareNum);
        }

        // 10진수로 변환한 값을 b진수로 변환
        int[] result = new int[20];
        int cnt = 0;
        while (true) {
            if (decimalTransformedNum < b) {
                result[cnt++] = decimalTransformedNum;
                break;
            } else {
                result[cnt++] = (decimalTransformedNum % b);
                decimalTransformedNum /= b;
            }
        }

        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }

        // 10진수로 변환한 값을 b진수로 변환
        /* 내가 짠 코드
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            if (decimalTransformedNum < b) {
                result.add(decimalTransformedNum);
                break;
            } else {
                result.add(decimalTransformedNum % b);
                decimalTransformedNum /= b;
            }
        }
                for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
        */

        System.out.println();
        System.out.println();

        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 메모리 사용량 측정
        // long usedMemory = (before - after) / 1024 / 1024;
        long usedMemory = (after - before);

        System.out.println("Used Memory : " + usedMemory);

        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        long heapSize = Runtime.getRuntime().maxMemory();
        // System.out.println("heap Memory : " + (heapSize / 1024 / 1024));
        System.out.println("heap Memory : " + (heapSize));
    }
}
