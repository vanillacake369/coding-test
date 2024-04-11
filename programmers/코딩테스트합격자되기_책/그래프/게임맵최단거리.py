from collections import deque


def solution(maps):
    answer = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q = deque()
    q.append((0, 0))

    while q:
        x, y = q.popleft()
        for i in range(0, 4):
            nextX = x + dx[i]
            nextY = y + dy[i]
            n = len(maps)
            m = len(maps[0])
            if 0 <= nextX < n and 0 <= nextY < m and maps[nextX][nextY] == 1:
                maps[nextX][nextY] = maps[x][y] + 1
                q.append((nextX, nextY))

    answer = maps[n - 1][m - 1]

    if answer == 1:
        answer = -1

    return answer


print(solution(maps=[[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1], [0, 0, 0, 0, 1]]))
