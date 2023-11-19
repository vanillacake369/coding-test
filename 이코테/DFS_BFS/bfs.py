from collections import deque

def bfs(graph, start, visited):
    # Queue
    queue = deque([start])
    # 현재 노드 방문처리
    visited[start] = True

    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 노드 추출 (deque의 왼쪽 끝 element return&제거)
        v = queue.popleft()
        print(v,end = ' ')
        #해당 원소와 연결된, 방문하지 않은 모든 이웃노드 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

graph = [
    [],
    [2,3,8], # 1번 노드 이웃 : 2,3,8
    [1,7] ,# 2번 노드 이웃 : 1,7
    [1,4,5], # 3번 노드 이웃 : 1,4,5
    [3,5] ,# 4번 노드 이웃 : 3,5
    [3,4] ,# 5번 노드 이웃 : 3,4
    [7] , # 6번 노드 이웃 : 7
    [2,6,6], # 7번 노드 이웃 : 2,6,8
    [1,7] # 8번 노드 이웃 : 1,7
]

# 방문처리 리스트
visited = [False] * 9

# 1번 노드부터 bfs
bfs(graph,1,visited)