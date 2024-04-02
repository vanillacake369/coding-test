"""
모든 노드에 대하여:
    다음방문노드 큐 선언
    각 이웃노드에 대하여:
        만약 이웃노드가 방문처리가 안 되었다면:
            이웃노드 큐에 다음방문노드 큐에 추가 // 그래야 이웃노드에 대해서도 bfs 처리
            이웃노드를 우선적으로 방문처리
"""
from collections import deque, defaultdict


def dfs(graph, start, result):
    queue = deque([start])
    visited = set()
    visited.add(start)
    result.append(start)

    while queue:
        node = queue.popleft()
        for neighbor in graph.get(node, []):
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
                result.append(neighbor)


def solution(graph, start):
    # u -> [v1,v2 ,,,] 형식으로 만들어야 하므로 "반드시" defaultdict 사용해야 함!!
    graphDict = defaultdict(list)
    for u, v in graph:
        graphDict[u].append(v)

    result = []
    dfs(graphDict, start, result)
    return result


graph = [
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (5, 8),
    (6, 9),
    (7, 9)
]
print(solution(graph, start=1))
