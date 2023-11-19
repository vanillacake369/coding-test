package programmers.안동대학교_스터디;

import java.util.*;

public class Assgmnt {
    // https://school.programmers.co.kr/learn/courses/30/lessons/176962
    public static void main(String[] args) {
        String[] answer = solution(new String[][]{
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}});
        for (String a : answer) {
            System.out.println(a);
        }
    }

    static class Class implements Comparable {
        String lec;
        int start;
        int time;

        public Class(String lec, String start, String time) {
            this.lec = lec;
            this.start = getStart(start);
            this.time = Integer.parseInt(time);
        }

        public int getStart(String s) {
            int h = Integer.parseInt(
                    s.split(":")[0]
            );
            int m = Integer.parseInt(
                    s.split(":")[1]
            );
            return h * 60 + m;
        }

        @Override
        public int compareTo(Object o) {
            Class c = (Class) o;
            return this.start - c.start;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<String>();

//        Class[] plansC = new Class[plans.length];
        List<Class> plansC = new ArrayList<Class>();
        for (int i = 0; i < plans.length; i++) {
            plansC.add(new Class(plans[i][0], plans[i][1], plans[i][2]));
        }
        plansC.stream().sorted();

        /*int next = 0;
        int now = plansC.get(next).start;
        Stack<Class> stop = new Stack<>();
        stop.add(plansC.get(next));
        while(!plansC.isEmpty() || !stop.isEmpty()){
            // 새 과제가 없음
            if(plansC.isEmpty()){
                answer.add(stop.pop().lec);
            }
            // 진행 중인 과제가 없음
            else if(stop.isEmpty()){
                now = plansC.get(next++).start;
                stop.push(plansC.get(n
            }
        }*/

        // 과제가 다 완료될 때까지
        /*while (answer.size() != plans.length) {
            System.out.println("next : " + next);
            System.out.println("now : " + now);
            System.out.println("plansC.get(next).time : " + plansC.get(next).time);
            System.out.println("plansC.get((next + 1) % plansC.size()).start : " + plansC.get((next + 1) % plansC.size()).start);
            System.out.println("stop.size : " + stop.size());

            // 과제 못 끝내고 넘어가야할 때
            if (now + plansC.get(next).time
                    > plansC.get((next + 1) % plansC.size()).start) {
                Class notDone = plansC.get(next);
                int notDoneTime = notDone.time;
                // 과제 진행시간 삭감
                notDone.time -= (plansC.get((next + 1) % plansC.size()).start - now);
                // 현재 시간 업데이트
                now += notDoneTime;
                // 멈춘 과제 스택에 푸시
                stop.push(notDone);
                // 과제 플랜 리스트에서 삭제
//                plansC.remove(next);
                // 다음 과제로 넘어감
                next = next + 1 % plans.length;
                continue;
            }
            // 과제 딱 맞춰서 끝냈을 때
            if (now + plansC.get(next).time
                    == plansC.get((next + 1) % plansC.size()).start) {
                // 정답 리스트에 추가
                answer.add(plansC.get(next).lec);
                // 과제 플랜 리스트에서 삭제
//                plansC.remove(next);
                // 다음 과제로 넘어감
                next = next + 1 % plans.length;
                continue;
            }
            // 과제 끝내고 시간 남음
            if (now + plansC.get(next).time
                    < plansC.get((next + 1) % plansC.size()).start) {
                if (!stop.isEmpty()) {
                    Class stopped = stop.pop();
                    // 남은 시간 동안 멈춘 과제 끝냄
                    if (plansC.get(next + 1).start - now
                            > stopped.time) {
                        // 정답 리스트에 추가
                        answer.add(plansC.get(next).lec);
                    } else { // 남은 시간 동안 멈춘 과제 못 끝냄
                        int stoppedTime = stopped.time;
                        // 과제 진행시간 삭감
                        stopped.time -= (plansC.get((next + 1) % plansC.size()).start - now);
                        // 현재 시간 업데이트
                        now += stoppedTime;
                        // 멈춘 과제 스택에 푸시
                        stop.push(stopped);
                    }
                    // 다음 과제로 넘어감
                    next = next + 1 % plans.length;
                    continue;
                }
            }
        }*/

        return answer.toArray(String[]::new);
    }

}
