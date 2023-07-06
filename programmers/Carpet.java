package programmers;

public class Carpet {
    public static void main(String[] args) {
//        int[] answer1 = solution(10, 2);
        int[] answer2 = solution(8, 1);
//        int[] answer3 = solution(24, 24);
        for (int a : answer2) {
            System.out.println(a);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int wY = 1, hB = 1, wB = 1;
        System.out.println(Math.sqrt(yellow));
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                wY = yellow / i;
                System.out.println("calculated brown : " + (2 * i + 2 * wY + 4));
                System.out.println("brown : " + brown);
                if (2 * i + 2 * wY + 4 == brown) {
                    hB = i + 2;
                    wB = wY + 2;
                    System.out.println("hB : " + hB);
                    System.out.println("wB : " + wB);
                    break;
                }
            }
        }
        answer[0] = wB;
        answer[1] = hB;
        return answer;
    }
}
