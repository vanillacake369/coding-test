package Codetree.NormalSorting;

import java.util.*;
import java.util.stream.Collectors;

/* k번째로 신기한 문자열 */
public class KthString {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> strListStartWithT = new ArrayList<>();
    /**
     * 의사코드
     * 1. n,k,T를 입력받는다.
     * 2. n번의 문자열을 입력받는다.
     * 3. 각 문자열이 T를 포함하고 있다면 T로 시작하는 단어 리스트에 - strListStartWithT - 추가한다.
     * 3-1. contains함수 사용
     * 4. 모든 문자열 입력이 끝났다면, T로 시작하는 단어 리스트를 사전식 정렬을 한다.
     * 4-1. 사전식 정렬 (아래 주석 참조)
     * 5. T로 시작하는 단어 리스트에서 k번째 단어를 출력한다.
     */
    /**
     * 사전식 정렬에는 다음과 같은 방법으로 구현가능
     * a. 직접 사전식 정렬 함수 생성 (아래 주석 참조)
     * b. Array.sort(arr)
     * b. Collections.sort(list)
     * c. list.sort(Collections.naturalOrder());
     * d. stream :: java 8
     *           List<String> sortedList = list.stream()
     * 			.sorted(Comparator.naturalOrder())
     * 			.collect(Collectors.toList());
     */
    /**
     * 사전식 정렬 프로세스 직접 생성
     * > 아래와 같은 문자열을 사전식 정렬하려면 어떻게 해야할까?
     * > 문자열 A :: apple
     * > 문자열 B :: appreciate
     * <p>
     * > 둘 중 길이가 적은 문자열 기준으로 루프
     * > 각 문자열을 비교하여 사전식으로 더 앞에 있는 문자열을 리스트에 먼저 삽입
     * // for(int i=0; i<A.length; i++){
     * //      if(A.charAt(i) == B.charAt(i))
     * //          continue;
     * //      if(A.charAt(i) > B.charAt(i)){
     * //          list.add(B);
     * //          list.add(A);
     * //      }
     * //      list.add(A);
     * //      list.add(B);
     * // }
     */
    public static void main(String[] args) {
        /* 입력 */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String t = scanner.next();
        // 버퍼 비우기
        scanner.nextLine();

        /* 연산 */
        // T로 시작하는 모든 문자열을 리스트에 저장
        saveAllStrStartWithT(n, t);
        // T로 시작하는 단어 리스트 사전정렬
        sortListInNatural();
        // k번째 단어 가져오기
        String kthStr = getKthStr(k);

        /* 출력 */
        System.out.println(kthStr);
    }

    private static String getKthStr(int k) {
        // k번째 문자열 반환
        return strListStartWithT.get(k - 1);
    }

    private static void sortListInNatural() {
        // natural order로 스트림 사용한 리스트 정렬
        strListStartWithT = strListStartWithT.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private static void saveAllStrStartWithT(int n, String t) {
        // 모든 n개의 문자열에 대해
        for (int i = 0; i < n; i++) {
            // 문자열 입력
            String inputStr = scanner.nextLine();
            // 입력받은 문자열이 t로 시작되면 리스트에 추가
            saveIfStartWithT(inputStr, t);
        }
    }

    private static void saveIfStartWithT(String inputStr, String t) {
        if (inputStr.startsWith(t)) {
            strListStartWithT.add(inputStr);
        }
    }

}
