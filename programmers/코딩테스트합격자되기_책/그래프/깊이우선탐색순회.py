"""
모든 노드에 대하여:
    이웃노드에 대하여:
        이웃노드가 방문되지 않았다면:
            다음 이웃노드에 대하여 dfs 호출
"""

from collections import defaultdict


# defaultdict라는 말 그대로 처음 키를 지정할 때 값을 주지 않으면 해당 키에 대한 값을 디폴트 값을 지정하겠다는 뜻이다.
# list 에 대해서는 [] 로 초기화, int 에 대해서는 0으로 초기화

def dfs(graphDict, node, visited, result):
    visited.add(node)
    result.append(node)
    for neighbor in graphDict.get(node, []):
        if neighbor not in visited:
            dfs(graphDict, neighbor, visited, result)


def solution(graph, start):
    graphDict = defaultdict(list)  # <- 이중배열에 대한
    for u, v in graph:
        graphDict[u].append(v)
    visited = set()
    result = []
    dfs(graphDict, start, visited, result)
    return result


graph = [
    ['A', 'B'],
    ['B', 'C'],
    ['C', 'D'],
    ['D', 'E']
]
result = solution(graph, start='A')
print(result)
