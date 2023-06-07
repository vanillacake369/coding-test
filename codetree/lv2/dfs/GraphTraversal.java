package codetree.lv2.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphTraversal {

    static boolean[] visited;
    static ArrayList<Integer> startPoints;
    static ArrayList<Integer> endPoints;
    static ArrayList<Integer>[] graph;

    /**
     * 의사코드
     *
     * DFS 실행 후 visted 배열에서 true인 값만 가져온다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        startPoints = new ArrayList<>();
        endPoints = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            startPoints.add(scanner.nextInt());
            endPoints.add(scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            graph[startPoints.get(i)].add(endPoints.get(i));
            graph[endPoints.get(i)].add(startPoints.get(i));
        }

        /*System.out.println("===============");
        for (int i = 1; i <= n; i++) {
            System.out.println(graph[i].toString());
        }
        System.out.println("===============");*/

        int rootVertex = 1;
        visited[rootVertex] = true;

        dfs(rootVertex);

        int countVisitedFromRoot = 0;
        for (int i = 0; i < visited.length; i++) {
            if (i != 1 && visited[i] == true)
                countVisitedFromRoot++;
        }

        System.out.println(countVisitedFromRoot);
    }

    private static void dfs(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int adjacent = graph[vertex].get(i);
            if (visited[adjacent] == false) {
                visited[adjacent] = true;
                dfs(adjacent);
            }
        }
    }
}
