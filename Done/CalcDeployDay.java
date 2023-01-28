package Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcDeployDay {
    public static void main(String[] args) {
        int[] progress = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        int[] answer = solution(progress, speeds);
        System.out.println("입출력 예 #1 : " + Arrays.toString(answer));

        System.out.println("-------");

        int[] progress1 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds1 = new int[]{1, 1, 1, 1, 1, 1};
        int[] answer1 = solution(progress1, speeds1);
        System.out.println("입출력 예 #2 : " + Arrays.toString(answer1));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] demandDays = new int[progresses.length];
        // 1. 작업필요일 : demandDays 을 구한다.
        for (int i = 0; i < progresses.length; i++) {
            int demandDay = (100 - progresses[i]) / speeds[i];
            demandDays[i] = demandDay;
            /* 소수점 올림처리
            int demandDay = (int) Math.ceil((100 - (float) progresses[i]) / (float) speeds[i]);
            if (((100 - progresses[i]) % speeds[i]) != 0) {
                demandDay++;
            }
            demandDays[i] = demandDay;
            */
        }
        // 2. 배포일에 대한 기능배포개수 계산
        // 작업 최대 필요일수
        int max = demandDays[0];
        // 기능배포개수
        int funcCount = 0;
        // 기능배포 리스트
        List<Integer> deployedFuncs = new ArrayList<Integer>();

        for (int i = 0; i < demandDays.length; i++) {
            // 이전 작업필요일보다 작은 경우
            if (demandDays[i] <= max) {
                funcCount++;
            }
            // 이전 작업필요일보다 큰 경우
            else if (demandDays[i] > max) {
                // max 최신화
                max = demandDays[i];
                // funcCount를 기능배포개수에 추가 후 초기화
                deployedFuncs.add(funcCount);
                funcCount = 1;
            }
            // 마지막 작업인 경우
            if (i == (demandDays.length - 1)) {
                // funcCount를 기능배포개수에 추가 후 초기화
                deployedFuncs.add(funcCount);
            }
        }
        return deployedFuncs.stream().mapToInt(Integer::intValue).toArray();
//        return demandDays;
    }
}
