package codetree.lv2.variable_scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfParticularScope {
    public static int[] arrA;

    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        String[] inputStrArr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputStrArr[0]);
        int m = Integer.parseInt(inputStrArr[1]);
        arrA = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> a1a2MemArr = new ArrayList<>();
        for (int i = 0; i < m * 2; i++)
            a1a2MemArr.add(scanner.nextInt());
        /* calc */
        ArrayList<Integer> result = getSumOfA(a1a2MemArr);
        /* result */
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static ArrayList<Integer> getSumOfA(ArrayList<Integer> a1a2MemArr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a1a2MemArr.size(); i += 2) {
            int startIndex = a1a2MemArr.get(i) - 1;
            int endIndex = a1a2MemArr.get(i + 1) - 1;
            int sum = 0;
            for (int j = startIndex; j <= endIndex; j++) {
                sum += arrA[j];
            }
            result.add(sum);
        }
        return result;
    }
    /*
     * 1. 입력
     *      1-1. 첫줄 : n m
     *      1-2. 2번째줄 : A의 원소
     *      1-3. 3번째줄 : a1,a2
     * 2. 수열 생성
     * 3. m길이의 a1,a2에 대한 리스트 생성
     * 3. m만큼의 루프 동안 수열[a1,a2 리스트]를 sum
     * 4. 출력
     * */
}
