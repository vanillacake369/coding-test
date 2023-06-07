package codetree.lv2.learn_iterator;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class GoldenRatioToast {
    private static int n, m;
    private static String breadState;
    private static LinkedList<Character> breads = new LinkedList<>();
    private static ListIterator<Character> it;

    public static void main(String[] args) {
        /* 입력 */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        breadState = scanner.next();
        // flush buffer
        scanner.nextLine();
        // 입력된 식빵 상태(breadState)를 연결리스트 형태로 만들기
        for (int i = 0; i < n; i++) {
            breads.add(breadState.charAt(i));
        }
        // Iterator를 이용한 list 내의 원소들 순회 (맨 뒤에서 시작)
        it = breads.listIterator(breads.size());

        /* calc */
        // 레시피의 암호 명령어 실행
        for (int i = 0; i < m; i++) {
            String command = scanner.nextLine();
            doCommand(breads, command);
        }
        /* result */
        String breadsState = getBreadsState(breads);
        System.out.println(breadsState);

    }


    /**
     * 레시피의 암호 명령어 실행
     *
     * @param breads
     * @param command
     */
    private static void doCommand(LinkedList<Character> breads, String command) {
        // 맨 앞이 아니라면 앞으로 이동
        if (command.contains("L")) {
            if (it.hasPrevious())
                it.previous();
        }
        // 맨 뒤가 아니라면 뒤로 이동
        if (command.contains("R")) {
            if (it.hasNext())
                it.next();
        }
        // 맨 뒤가 아니라면 뒤에 있는 빵 제거
        if (command.contains("D")) {
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
        // 현 위치에 문자 추가
        if (command.contains("P")) {
            Character bread = command.charAt(2);
            it.add(bread);
        }
    }

    /**
     * 식빵 상태 문자열 가져오기
     * : 식빵 연결리스트를 식빵 문자열로 변환
     *
     * @param breads
     * @return
     */
    private static String getBreadsState(LinkedList<Character> breads) {
        StringBuilder sb = new StringBuilder();

        // Appends characters one by one
        for (Character ch : breads) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
