def dfs(graph,v,visited):
    # 현재 노드 방문 처리
    visited[v] = True
    print(v, end=' ')

    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

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

# 1번 노드부터 dfs
dfs(graph,1,visited)