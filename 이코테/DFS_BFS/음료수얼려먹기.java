package 이코테.DFS_BFS;

import java.util.Scanner;

// 인접행렬에서 구역을 나누는 문제
// BFS로 풀던, DFS로 풀던 상돤없는 문제
public class 음료수얼려먹기 {

    // 로직에 사용될 변수
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m)
            return false;
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            // 상
            dfs(x, y + 1);
            // 하
            dfs(x, y - 1);
            // 좌
            dfs(x - 1, y);
            // 우
            dfs(x + 1, y);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine(); // 0110
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0'; // [0][1][1][0]
            }
        }

        // 모든 노드에 대해 음료수 채우기
        // 아이스크림 카운트 변수
        int result = 0;
        // 모든 인덱스에 대해
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 노드에 대해 BFS(DFS) 수행, 수행 완료 시 아이스크림 카운트
                if (dfs(i, j)) { // DFS
                    result += 1;
                }
            }
        }

        // 최종 아이스크림 개수 출력
        System.out.println(result);
    }
}
