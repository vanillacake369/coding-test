package programmers;

public class CompareContainsFrontBackSearch {
    public static void main(String[] args) {
        String data = "iloveyou";
        String cc = "i";
        char c = 'i';
        long beforeTime = 0; //코드 실행 전에 시간 받아오기
        long afterTime = 0; // 코드 실행 후에 시간 받아오기
        long secDiffTime = 0; //두 시간에 차 계산
        boolean isContain = false;

        // contains 시간 측정
        beforeTime = System.nanoTime(); //코드 실행 전에 시간 받아오기
        isContain = data.contains(cc);
        afterTime = System.nanoTime(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("contains : " + secDiffTime);
        System.out.println("result : " + isContain);

        // frontAndBackSearch 시간 측정
        char[] dataChar = data.toCharArray();
        beforeTime = System.nanoTime(); //코드 실행 전에 시간 받아오기
        isContain = frontAndBackSearch(dataChar, c);
        afterTime = System.nanoTime(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("frontAndBackSearch : " + secDiffTime);
        System.out.println("result : " + isContain);
    }

    public static boolean frontAndBackSearch(char[] arr, char data) {
        int front = 0;
        int back = arr.length - 1;

        // 맨 앞의 index에서부터 시작해 가운데로 가며 탐색 :: O(logN)
        while (front <= back) {
            if ((arr[front] == data) || (arr[back] == data)) {
                return true;
            }
            front++;
            back--;
        }

        // 검색값이 없으면 null 반환
        return false;
    }
}
