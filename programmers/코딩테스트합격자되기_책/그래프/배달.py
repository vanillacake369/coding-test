# 노드 테이블 생성
# 1번 노드에 대해서
#   다른 노드로 가는 최소거리
# 노드 개수 구하기 :: 1번 노드 -> 다른 노드 비용 <= K
import heapq


def solution(N, road, K):
    answer = 0
    # 거리테이블
    # distances = {node: float('inf') for node in range(N)}
    distances = [float('inf')] * (N + 1)
    # 그래프
    graph = [[] for _ in range(N + 1)]
    # 시작점, 그래프, 거리테이블 초기화
    start = 1
    distances[start] = 0
    for startNode, endNode, cost in road:
        graph[startNode].append((endNode, cost))
        graph[endNode].append((startNode, cost))
    # 큐
    queue = []
    # 시작노드 -> 큐
    heapq.heappush(queue, (distances[start], start))

    while queue:
        # 현재 최소 거리 노드
        currentDist, currentNode = heapq.heappop(queue)
        # 거리테이블 값이 최소라면 업데이트 X
        if distances[currentNode] < currentDist:
            continue
        # 현재 노드 인접노드 간 거리계산, 업데이트
        for adjNode, weight in graph[currentNode]:
            dist = weight + currentDist
            if dist < distances[adjNode]:  # "기존거리값" > "노드->인접노드" 이라면 거리테이블 업데이트
                distances[adjNode] = dist
                heapq.heappush(queue, (dist, adjNode))

    print(distances)

    # 최소 거리가 K 이하인 노드 개수 구하기
    sum = 0
    for d in distances:
        if d <= K:
            sum += 1

    return sum


N = 5
road = [[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]]
K = 3

print(solution(N, road, K))
