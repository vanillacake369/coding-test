package programmers.안동대학교_스터디;

public class TicTacToe {
    // https://school.programmers.co.kr/learn/courses/30/lessons/160585

    // 아래 풀이는 틀렸다. 왜냐하면 X와 O의 개수가 같지만, X가 승리한 경우가 존재하는데 이를 생각하지 않았기 때문이다.
    // 해당 풀이를 참조하자 : https://velog.io/@c4fiber/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%98%BC%EC%9E%90%EC%84%9C-%ED%95%98%EB%8A%94-%ED%8B%B1%ED%83%9D%ED%86%A0-c-%ED%92%80%EC%9D%B4

    public static void main(String[] args) {

        /*String[] board1 = {"O.X", ".O.", "..X"};
        System.out.println(solution(board1));*/

        /*String[] board1 = {"OOO", "...", "XXX"};
        System.out.println(solution(board1));*/

        /*String[] board1 = {"...", ".X.", "..."};
        System.out.println(solution(board1));*/

        String[] board1 = {"...", "...", "..."};
        System.out.println(solution(board1));
    }

    public static int solution(String[] board) {
        if (isValidBoard(board))
            return 1;
        else
            return 0;
    }

    private static boolean isValidBoard(String[] board) {
        boolean isFirstO = true;
        boolean isFirstX = true;
        boolean isWinnerO = false;
        boolean isWinnerX = false;
        int countO = 0;
        int countX = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("board[i].charAt(j) : " + board[i].charAt(j));
                if (board[i].charAt(j) == 'O') {
                    if (isFirstO == true) {
                        isWinnerO = checkWinner('0', board, i, j);
                        System.out.println(isWinnerO);
                    }
                    isFirstO = false;
                    countO++;
                }
                if (board[i].charAt(j) == 'X') {
                    if (isFirstX == true) {
                        isWinnerX = checkWinner('X', board, i, j);
                        System.out.println(isWinnerX);
                    }
                    isFirstX = false;
                    countX++;
                }
            }
        }

        System.out.println("countO : " + countO);
        System.out.println("countX : " + countX);
        System.out.println("isWinnerO : " + isWinnerO);
        System.out.println("isWinnerX : " + isWinnerX);

        if (0 <= countX && countX < countO) {
            System.out.println("less X than O");
            return true;
        } else if (countX == countO && isWinnerO == false && isWinnerX == false) {
            System.out.println("Both are not winner");
            return true;
        }
        return false;
    }

    private static boolean checkWinner(char player, String[] board, int i, int j) {
        if (player == 'O') {
            if (board[i].equals("OOO")) {
                return true;
            }
            if (board[j].equals("OOO")) {
                return true;
            }
            if (board[0].charAt(0) == 'O'
                    && board[0].charAt(0) == board[1].charAt(1)
                    && board[1].charAt(1) == board[2].charAt(2)) {
                return true;
            }
            if (board[2].charAt(0) == 'O'
                    && board[2].charAt(0) == board[1].charAt(1)
                    && board[1].charAt(1) == board[0].charAt(2)) {
                return true;
            }
        } else {
            if (board[i].equals("XXX")) {
                return true;
            }
            if (board[j].equals("XXX")) {
                return true;
            }
            if (board[0].charAt(0) == 'X'
                    && board[0].charAt(0) == board[1].charAt(1)
                    && board[1].charAt(1) == board[2].charAt(2)) {
                return true;
            }
            if (board[2].charAt(0) == 'X'
                    && board[2].charAt(0) == board[1].charAt(1)
                    && board[1].charAt(1) == board[0].charAt(2)) {
                return true;
            }
        }
        return false;
    }
}
