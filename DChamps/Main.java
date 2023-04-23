package DChamps;

import java.util.*;

public class Main {
    /*
     * 성적 배열 내에서 원소가 몇 번째인지 찾고 => 순위 부여 로직
     * 상위 3퍼에 A,그 다음 4퍼에 B, 그 다음 3퍼에 C 부여 => 등급 부여 규칙
     * */
    /*
     * 순위 부여 로직 #1
     * 1. [초기 순서][점수] 구조 initialA 생성 :: 이중연결리스트 사용
     * 2. 점수리스트 정렬
     * 3. 정렬된 점수리스트의 순위에 따라 grade 부여
     *      3-1. for loop on 점수
     *          3-1-a. get 초기순서 of initialA[초기순서][점수]
     *          3-1-b. insert grade to 'rank[초기순서]'
     * */
    /*
     * 순위 부여 로직 #2
     * 1. A로부터 원소를 하나씩 읽어온다.
     * 1. 점수,등급,기존순서에 대한 학생 객체를 생성한다.
     * 2. 학생객체에 대한 double-ended queue :: grade 를 생성한다.
     * 3. grade에 읽어온 학생 객체를 아래 로직에 따라 저장한다.
     *      3-1. 자신보다 작은 점수라면 존재하면 다음 학생과 비교한다.
     *      3-2. 다음 학생이 자신보다 큰 점수라면 이전학생과 다음 학생 사이에 자신을 삽입한다.
     * */
    /*
     * 정렬된 점수에서 순서 찾아 등급부여
     * 1. 점수배열인 A를 정렬한 정렬된점수배열 B를 만든다.
     * 2. A의 원소 하나를 읽는다.
     * 3. 읽은 원소가 B에서 몇 번째인지 찾아낸다.
     *      3-1. 동일점수에 대한 추가 로직 처리
     *          3-1-a. 정렬된점수배열에 대한 접근카운트배열을 생성한다.
     *          3-1-b. 만약 원소를 찾아내었다면, 접근카운트배열을 ++ 한다.
     *          3-1-c. 만약 이전에 한 번 읽은 기록이 있다면 다음 인덱스를 탐색한다.
     * 4. 찾아낸 순서를 등급부여로직에 의해 등급을 부여한다.
     * 5. 부여한 등급을 전체등급문자열에 합친다.
     * 6. A의 전체길이만큼 반복한다.(더 이상 읽을 원소가 없으면 멈춘다)
     * 7. 전체등급문자열을 반환한다.
     * */
    public static void main(String[] args) {
        /* input */
        int N = 7;
        int[] A = {70, 45, 69, 69, 77, 81, 33};
        /* calc */
        /* 1. 점수배열인 A를 정렬한 정렬된점수배열 B를 만든다. */
        int[] SortedA = Arrays.copyOf(A, A.length);
        Arrays.sort(SortedA);
        String wholeGrade = ""; // 전체등급문자열(결과값)
        int[] checkGetGrade = new int[SortedA.length];
        /* 순서 찾아 등급부여 */
        for (int i = 0; i < A.length; i++) {
            String grade = getGrade(SortedA, A[i], checkGetGrade);
            wholeGrade += grade;
        }
        /* result */
        System.out.println(wholeGrade);
        System.out.println(Arrays.toString(SortedA));
    }

    private static String getGrade(int[] SortedA, int A, int[] checkGetGrade) {
        // A의 원소를 읽는다.
        int currentScore = A;
        int rankOfCurrentScore = 0;
        rankOfCurrentScore = getRankOfCurrentScore(SortedA, checkGetGrade, currentScore, rankOfCurrentScore);
        // 등급조건에 따라 등급을 부여한다.
        System.out.print("점수 : " + currentScore);
        return rankGrade(rankOfCurrentScore, SortedA.length);
    }

    private static int getRankOfCurrentScore(int[] SortedA, int[] checkGetGrade, int currentScore, int rankOfCurrentScore) {
        // 원소의 순위를 찾는다.
        for (int j = 0; j < SortedA.length; j++) {
            // 읽은 적이 있다면 다음 원소를 찾는다.
            if (hasRead(j, checkGetGrade)) {
                continue;
            }
            if (SortedA[j] == currentScore) {
                rankOfCurrentScore = j;
                checkGetGrade[j] = 1; // 찾으면 읽은 표시를 해둔다.
            }
        }
        return rankOfCurrentScore;
    }

    private static boolean hasRead(int j, int[] checkGetGrade) {
        return (checkGetGrade[j] == 1);
    }

    private static String rankGrade(int rankOfCurrentScore, int studentCount) {
        /*
         * grade rule
         * In sorted score, rank grade with following condition
         * 1. A :: count - (count*0.3) <=  < count
         * 2. B :: count - (count*0.7) <= < count - (count*0.3)
         * 3. C ::
         * */
        /*A*/
        int standardOfA = (int) Math.floor((studentCount - (studentCount * 0.3)));
        int standardOfB = (int) Math.floor((studentCount - (studentCount * 0.7)));
        if ((rankOfCurrentScore > standardOfA) && (rankOfCurrentScore < studentCount)) {
            System.out.print(",A기준 : " + standardOfA);
            System.out.print(",순위 : " + rankOfCurrentScore);
            System.out.println(",등급 : " + "A");
            return "A";
        }
        /*B*/
        if ((rankOfCurrentScore > standardOfB) && (rankOfCurrentScore <= standardOfA)) {
            System.out.print(",B기준 : " + standardOfB);
            System.out.print(",순위 : " + rankOfCurrentScore);
            System.out.println(",등급 : " + "B");
            return "B";
        }
        System.out.print(",순위 : " + rankOfCurrentScore);
        System.out.println(",등급 : " + "C");
        /*C*/
        return "C";
    }
}