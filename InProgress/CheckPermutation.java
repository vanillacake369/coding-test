package InProgress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckPermutation {
    public static void main(String[] args) {
        int[] testArr1 = {4, 1, 3, 2};
        int[] testArr2 = {4, 1, 3};
        System.out.println("test case1 : " + solution(testArr1));
        System.out.println("test case2 : " + solution(testArr2));
    }
    public static boolean solution(int[] arr) {
        boolean answer = true;
        // ArrayList로 변환
        List<Integer> arrayList = IntStream.of(arr).boxed().collect(Collectors.toList());
        System.out.println(arrayList.toString());
        // 정렬
        Collections.sort(arrayList);
        // 정렬된 리스트가 순열을 이루는지 검사
        for (int i = 0; i < arrayList.size(); i++) {
            if(i != (arrayList.size()-1)){
                if( (arrayList.get(i+1)-arrayList.get(i)) > 1)
                    answer = false;
            }
        }
        return answer;
    }
}
