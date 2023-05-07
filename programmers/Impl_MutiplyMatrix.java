package programmers;

import java.util.Scanner;

/*
* N개의 줄에 행렬 A와 B를 곱한 행렬 출력
첫째줄 : A의 N,M => A[N][M]
둘째줄 ~ N개의 줄 : A의 원소가 M개만큼 순서대로 A[0~N][...M]
N+1째 줄 : B의 M,K => B[M][K]
N+2째 줄 ~ : B의 원소가 K개만큼 순서대로 B[0~

3,2
=>
[][]
[][]
[][]

1 2
3 4
5 6
=>
[1][2]
[3][4]
[5][6]

2 3
=>
[][][]
[][][]

-1 -2 0
0 0 3
=>
[-1][-2][0]
[0][0][3]

AB[x][y]
=> A[0~][x] * B[y][0~]
* */
public class Impl_MutiplyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A 크기 입력 후 A 생성
        String sizeOfA = scanner.nextLine();
        int rowOfA = sizeOfA.charAt(0) - '0';
        int colOfA = sizeOfA.charAt(2) - '0';
        int[][] a = new int[rowOfA][colOfA];

        // A 데이터 입력
        for (int i = 0; i < rowOfA; i++) {
            String dataOfA = scanner.nextLine();
            dataOfA = dataOfA.replaceAll("\\s", "");
            for (int j = 0; j < colOfA; j++) {
                a[i][j] = dataOfA.charAt(j) - '0';
            }
        }

        // B 크기 입력 후 B 생성
        String sizeOfB = scanner.nextLine();
        int rowOfB = sizeOfB.charAt(0) - '0';
        int colOfB = sizeOfB.charAt(2) - '0';
        int[][] b = new int[rowOfB][colOfB];

        // B 데이터 입력
        for (int i = 0; i < rowOfB; i++) {
            String dataOfB = scanner.nextLine();
            dataOfB = dataOfB.replaceAll("\\s", "");
            for (int j = 0; j < colOfB; j++) {
                a[i][j] = dataOfB.charAt(j) - '0';
            }
        }

        // 결과 행렬 계산 :: AB[x][y] => A의 x행 성분 x B의 y열 성분
        //
        int[][] result = new int[rowOfA][colOfB];
        // 행렬 곱셈 패턴을 그려보자 ㅠㅠ;;


    }
}
