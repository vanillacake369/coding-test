import heapq


def solution(graph, start):
    # 모든 노드 거리 테이블
    distances = {node: float('inf') for node in graph}
    # 시작노드 거리값 초기화
    distances[start] = 0
    # 큐
    queue = []
    # 시작노드 -> 큐
    heapq.heappush(queue, [distances[start], start])
    # 시작 노드 경로 초기화
    paths = {start: [start]}

    while queue:
        # 현재 최소 거리값의 노드 (by heapq)
        currentDist, currentNode = heapq.heappop(queue)
        # 거리테이블의 값이 최소라면 -- 현재 최소 거리값이 더 작다면 -- 무시 (업데이트 X)
        if distances[currentNode] < currentDist:
            continue
        # 현재 노드와 인접한 노드들 거리값 계산, 업데이트
        for adjNode, weight in graph[currentNode].items():
            distance = currentDist + weight  # 노드 -> 인접노드 비용 계산
            if distance < distances[adjNode]:  # "기존거리값" > "노드 -> 인접노드 비용" 이라면 업데이트
                distances[adjNode] = distance
                paths[adjNode] = paths[currentNode] + [adjNode]
                heapq.heappush(queue, [distance, adjNode])

    sortedPaths = dict(list(sorted(paths.items(), key=lambda p: p[1])))

    return [distances, sortedPaths]


graph = {
    "A": {"B": 9, "C": 3},
    "B": {"A": 5},
    "C": {"B": 1}
}
start = "A"
print(solution(graph, start))
