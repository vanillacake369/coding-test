package programmers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class OpenChatting {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42888

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] resultSol = solution(record);
        boolean isAnswer = true;
        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals(resultSol[i])) {
                isAnswer = false;
                System.out.println(i + " 번째에서 " + "정답은 " + result[i] + " 이지만, 결과는 " + resultSol[i] + " 였습니다.");
            }
        }
        if (isAnswer) {
            System.out.println("정답입니다.");
        }
    }


    static Stack<String> nameStack = new Stack<>();
    static Stack<String> actStack = new Stack<>();
    static Hashtable<String, String> nameTable = new Hashtable<>();

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        String[] temp;

        for (String r : record) {
            temp = r.split(" ");
            if (temp[0].equals("Enter")) {
                nameTable.put(temp[1], temp[2]);
                nameStack.push(temp[1]);
                actStack.push("님이 들어왔습니다.");
            }
            if (temp[0].equals("Leave")) {
                nameStack.push(temp[1]);
                actStack.push("님이 나갔습니다.");
            }
            if (temp[0].equals("Change")) {
                nameTable.put(temp[1], temp[2]);
            }
        }

        while (!actStack.isEmpty()) {
            String each = nameTable.get(nameStack.pop()) + actStack.pop();
            answer.add(0, each);
        }

        return answer.toArray(String[]::new);
    }
}
