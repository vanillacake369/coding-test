package codetree.lv2.brute_force_2;

import java.util.*;

public class TheGraceFormTeacher2 {

    /**
     * 의사코드
     *
     * 학생 n명의 선물 가격 p에 대한 배열 생성
     *
     * # 1 12에게 쿠폰
     * - 12/2 // 6
     * - 12/2, 8 // 14
     * - 12/2, 8, 6 // 20 이므로 중단
     * 12에게 쿠폰 먹였을 때는 최대 2명
     *
     * # 2 8에게 쿠폰
     * - 8/2 // 4
     * - 8/2, 6 // 10
     * - 8/2, 6, 4 // 14
     * - 8/2, 6, 4, 2 // 16
     * - 더 이상 뽑을 사람이 없으므로 중단
     * 8에게 쿠폰 먹였을 떄는 최대 4명
     *
     * 선물가능최대명수 출력
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int[] p = new int[n];
        int resultPresentsCount = 0;
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        ArrayList<Integer> presentList = new ArrayList<>();

        /**
         * # 1 12에게 쿠폰
         * - 12/2 // 6
         * - 12/2, 8 // 14
         * - 12/2, 8, 6 // 20 이므로 중단
         * 12에게 쿠폰 먹였을 때는 최대 2명
         *
         * # 2 8에게 쿠폰
         * - 8/2 // 4
         * - 8/2, 6 // 10
         * - 8/2, 6, 4 // 14
         * - 8/2, 6, 4, 2 // 16
         * - 더 이상 뽑을 사람이 없으므로 중단
         * 8에게 쿠폰 먹였을 떄는 최대 4명
         */
        int[] pDesc = Arrays.stream(p).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        // 각 선물에게 쿠폰을 먹일 때에 대해
        for (int i = 0; i < n; i++) {
            presentList.clear(); // 선물리스트 비우기
            // 쿠폰 적용
            presentList.add(pDesc[i] / 2);
            int sumOfPresents = presentList.get(0);
            // 다음 선물을 추가했을 때 예산이 넘어가지 않는다면 선물 추가
            for (int j = i; j < n; j++) {
                if ((sumOfPresents += pDesc[j]) <= b)
                    presentList.add(pDesc[j]);
            }
            // 예산을 넘기지 않는 선에서의 최대 선물 가능 수를 저장
            resultPresentsCount = Math.max(presentList.size(), resultPresentsCount);
        }

        System.out.println(resultPresentsCount);


    }
}
