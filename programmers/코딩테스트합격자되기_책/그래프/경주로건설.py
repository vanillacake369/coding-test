"""
직선 : 100원
코너 : 600원

bfs 를 통해 시작점 -> 도착점 도달하는 각각의 경우에 대해 비용을 계산, min 을 업데이트


from collections import deque


def isOutOfBounds(nextY, nextX, size):
    return 0 <= nextY < size and 0 <= nextX < size


def isObstacle(nextY, nextX, board):
    return (nextX == 0 and nextY == 0) or not isOutOfBounds(nextY, nextX, len(board)) or board[nextY][nextX] == 1


def getCostOf(i, previousDirect, cost):
    # 직진 코스
    if previousDirect == -1 or ((previousDirect - i) % 2 == 0):
        return cost + 100
    # 코너 코스
    return cost + 600


def isNotArrivedOrMinNewCost(nextY, nextX, i, newCost, visited):
    visitCurr = visited[nextY][nextX][i]
    return visitCurr == 0 or visitCurr > newCost


def solution(board):
    answer = 0
    # 상하좌우
    direction = [
        [-1, 0]
        , [0, 1]
        , [0, -1]
        , [1, 0]
    ]
    visited = [[[0 for _ in range(4)] for _ in range(len(board))] for _ in range(len(board))]
    queue = deque()
    queue.append((0, 0, -1, 0))

    while queue:
        y, x, previousDirect, cost = queue.popleft()
        for i, eachDirection in enumerate(direction):
            nextY = eachDirection[0] + y
            nextX = eachDirection[1] + x
            # 밖을 넘지 않았거나 AND 장애물이 아닌 경우
            if isOutOfBounds(nextY, nextX, len(board)) or isObstacle(nextY, nextX, board):
                continue
            else:
                # 새로운 비용 계산
                newCost = getCostOf(i, previousDirect, cost)
                # 도착점인 경우 => answer 에 반환
                if nextY == len(board) - 1 and nextX == len(board) - 1:
                    answer = min(answer, newCost)
                # 도착점이 아닌 경우이거나 새 비용이 더 적은 경우 => 큐에 추가하여 다음 탐색
                elif isNotArrivedOrMinNewCost(nextY, nextX, i, newCost, visited):
                    queue.append((nextY, nextX, i, newCost))
                    visited[nextY][nextX][i] = newCost

    return answer
"""


def solution(board):
    # ➊ 주어진 좌표가 보드의 범위 내에 있는지 확인
    def is_valid(x, y):
        return 0 <= x < N and 0 <= y < N

    # ➋ 주어진 좌표가 차단되었거나 이동할 수 없는지 확인
    def is_blocked(x, y):
        return (x, y) == (0, 0) or not is_valid(x, y) or board[x][y] == 1

    # ➌ 이전 방향과 현재 방향에 따라 비용을 계산
    def calculate_cost(direction, prev_direction, cost):
        if prev_direction == -1 or (prev_direction - direction) % 2 == 0:
            return cost + 100
        else:
            return cost + 600

    # ➍ 주어진 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우
    def isShouldUpdate(x, y, direction, new_cost):
        return visited[x][y][direction] == 0 or visited[x][y][direction] > new_cost

    queue = [(0, 0, -1, 0)]
    N = len(board)
    directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    visited = [[[0 for _ in range(4)] for _ in range(N)] for _ in range(N)]
    answer = float("inf")

    # ➎ 큐가 빌 때까지 반복
    while queue:
        x, y, prev_direction, cost = queue.pop(0)

        # ➏ 가능한 모든 방향에 대해 반복
        for direction, (dx, dy) in enumerate(directions):
            new_x, new_y = x + dx, y + dy

            # ➐ 이동할 수 없는 좌표는 건너뛰기
            if is_blocked(new_x, new_y):
                continue

            new_cost = calculate_cost(direction, prev_direction, cost)

            # ➑ 도착지에 도달한 경우 최소 비용 업데이트
            if (new_x, new_y) == (N - 1, N - 1):
                answer = min(answer, new_cost)
            # ➒ 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우 큐에 추가
            elif isShouldUpdate(new_x, new_y, direction, new_cost):
                queue.append((new_x, new_y, direction, new_cost))
                visited[new_x][new_y][direction] = new_cost

    return answer


board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
print(solution(board))
