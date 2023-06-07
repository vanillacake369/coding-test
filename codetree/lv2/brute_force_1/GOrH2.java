package codetree.lv2.brute_force_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GOrH2 {
    /**
     * 의사코드
     *
     * 팻말 객체를 생성한다 : {팻말값,인덱스}
     * 팻말 리스트 asc 정렬 by 인덱스
     * 각 팻말에 대해 :: i
     *      나머지 팻말에 대해 :: j
     *          G와 H 등장횟수 카운트
     *          G와 H 등장횟수가 서로 같다면 팻말의 인덱스를 사진가능인덱스 리스트에 add
     *      사진크기를 구한다
     *      = 사진가능인덱스 리스트 끝의 값 - i번째 팻말의 인덱스
     *
     * 예외케이스는?
     * 입력이 하나만 주어졌을 떄 무조건 0반환
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        ArrayList<Signpost> signpostArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            char sign = scanner.next().charAt(0);
            Signpost signpost = new Signpost(sign, index);
            signpostArrayList.add(signpost);
        }
        int maxPhotoSize = 0;

        // 정렬
        List<Signpost> signpostArrayListAsc =
                signpostArrayList.stream().sorted().collect(Collectors.toList());

        // 각 인덱스에 대해
        for (int i = 0; i < n; i++) {
            int countG = 0;
            int countH = 0;

            if (signpostArrayListAsc.get(i).sign == 'G') {
                ++countG;
            }
            if (signpostArrayListAsc.get(i).sign == 'H') {
                ++countH;
            }

            List<Integer> possibleIndexs = new ArrayList<>();
            // 나머지 인덱스에 대해 G와 H가 동일하게 등장하면 리스트에 저장
            for (int j = i + 1; j < n; j++) {
                if (signpostArrayListAsc.get(j).sign == 'G') {
                    ++countG;
                }
                if (signpostArrayListAsc.get(j).sign == 'H') {
                    ++countH;
                }
                if (countG == countH) {
                    possibleIndexs.add(signpostArrayListAsc.get(j).index);
                }
            }
            if (possibleIndexs.size() > 0) {
                maxPhotoSize = Math.max(maxPhotoSize, (possibleIndexs.get(possibleIndexs.size() - 1) - signpostArrayListAsc.get(i).index));
            }
        }

        System.out.println(maxPhotoSize);
    }

    static class Signpost implements Comparable {

        char sign;
        int index;

        public Signpost(char sign, int index) {
            this.sign = sign;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            Signpost signpost = (Signpost) o;
            return this.index - signpost.index;
        }
    }
}
