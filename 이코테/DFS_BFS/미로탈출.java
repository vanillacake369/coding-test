package 이코테.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate {
    public static int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}

public class 미로탈출 {
    public static int n, m;
    public static int[][] graph = new int[200][200];

    /*
     * > 이 문제에서는 인접행렬이기 때문에 visited 배열 처리를 graph에 값을 표기함을 통해 visited처리를 한다.
     * 1. 큐를 생성한다.
     * 2. visited에 시작정점 (1,1)을 넣는다.
     * 3. 큐에 시작정점(1,1)을 enqueue한다.
     * 1. pathCount에 현재 정점 이동 카운트인 1로 최신화한다.
     * 4. 큐가 빌 때까지 이웃정점들을 방문한다.
     * 1. q에서 정점 하나를 (큐의 head) dequeue한다.
     * 2. dequeue한 노드의 이웃정점들에 대해
     * 1. 이 때, 이웃정점이 0이거나, 인덱스 범위를 넘어가면 스킵한다.
     * 1. 이동카운트를 +1한다.
     * 2. visited에 이웃정점을 넣는다.
     * 3. 이웃정점을 enqueue한다.
     * 5. 탐색이 완전히 종료되면 이동 카운트를 반환한다.
     */

    public static int findShortestPathBFS(int[][] graph, int rootX, int rootY) {
        int moveCount = 1;

        // 1. 큐를 생성한다.
        Queue<Coordinate> queue = new LinkedList<Coordinate>();

        // 2. visited에 시작정점 (1,1)을 넣는다.
        // 3. 큐에 시작정점(1,1)을 enqueue한다.
        queue.offer(new Coordinate(rootX, rootY));

        // 4. 큐가 빌 때까지 이웃정점들을 방문한다.
        while (!queue.isEmpty()) {
            // 1. q에서 정점 하나를 (큐의 head) dequeue한다.
            Coordinate node = queue.poll();

            // 2. dequeue한 노드의 이웃정점들에 대해
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int adjNodeX = node.getX();
                    int adjNodeY = node.getY();
                    // 1. 이 때, 이웃정점이 0이거나, 인덱스 범위를 넘어가면 스킵한다.
                    // 왜 벽은 생각 안 했니!! ㅠㅠ
                    /*
                     * if (adjNodeX < 0 || adjNodeX > 4 || adjNodeY < 0 || adjNodeY > 200) {
                     * continue;
                     * }
                     */

                    // 미로 찾기 공간을 벗어난 경우 무시
                    if (adjNodeX < 0 || adjNodeX >= n || adjNodeY < 0 || adjNodeY >= m)
                        continue;
                    // 벽인 경우 무시
                    if (graph[adjNodeX][adjNodeY] == 0)
                        continue;

                    // 1. 이동카운트를 +1한다.
                    moveCount++;
                    // 2. visited에 이웃정점을 넣는다.
                    graph[adjNodeX][adjNodeY] = moveCount;
                    // 3. 이웃정점을 enqueue한다.
                    queue.offer(new Coordinate(adjNodeX, adjNodeY));
                }
            }
        }

        // 5. 마지막 정점 또한 포함해서 이동 개수를 계산하기에

        return moveCount;
    }

    public static void main(String[] args) {
        int movedPathCountResult = 0;

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

        movedPathCountResult = findShortestPathBFS(graph, 0, 0);

        System.out.println(movedPathCountResult);
    }
}
