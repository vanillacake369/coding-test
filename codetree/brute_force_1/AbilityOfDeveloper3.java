package codetree.brute_force_1;

import java.util.Scanner;

public class AbilityOfDeveloper3 {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] developersValues = new int[6];
    private static int minValue = 0;

    /**
     * 의사코드
     *
     * 1. 개발자 6명 중 1명에 대한 루프
     *      나머지 인원 중 1명에 대한 루프
     *          나머지 인원 중 1명에 대한 루프
     *              1-1. ( (세 명을 고른 값의 합) - (나머지 세 명의 합) ) 의 절대값을 구한다.
     *              1-2. 해당 절대값이 최소값이라면 절대값의 최소값으로 등록한다.
     * 2. 절대값의 최소값으로 출력한다.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            developersValues[i] = scanner.nextInt();
        }
        int allDevelopersValues = 0;
        for (int i = 0; i < 6; i++) {
            allDevelopersValues += developersValues[i];
        }
        minValue = allDevelopersValues; // 초기에는 모든 개발자 수치의 합으로 저장. 이후 최소값 구할 시 최소값 저장
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    int teamA = developersValues[i] + developersValues[j] + developersValues[k];
                    int teamB = allDevelopersValues - teamA;
                    int subAB = Math.abs(teamA - teamB);
                    if (subAB < minValue)
                        minValue = subAB;
                }
            }
        }
        System.out.println(minValue);
    }
}
