from collections import deque


def getSafeSection(rainDepth, grid):
    safeSectionCount = 0
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and grid[i][j] > rainDepth:
                bfs(i, j, grid, rainDepth, visited)
                safeSectionCount += 1
    return safeSectionCount


def bfs(i, j, grid, rainDepth, visited):
    queue = deque()
    queue.append((i, j))
    visited[i][j] = True
    while queue:
        currentI, currentJ = queue.popleft()
        for di, dj in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            nextI, nextJ = currentI + di, currentJ + dj
            if (0 <= nextI < N and 0 <= nextJ < N
                    and not visited[nextI][nextJ]
                    and grid[nextI][nextJ] > rainDepth):
                queue.append((nextI, nextJ))
                visited[nextI][nextJ] = True


N = int(input())
grid = []
maxRainDepth = 0
for i in range(N):
    eachInputRow = list(map(int, input().split()))
    maxRainDepth = max(maxRainDepth, max(eachInputRow))
    grid.append(eachInputRow)
rainDepth = 1
answer = 0
for i in range(maxRainDepth):
    answer = max(answer, getSafeSection(i, grid))
print(answer)
