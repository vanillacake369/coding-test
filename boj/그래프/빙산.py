from collections import deque


def bfs(i, j, v):
    queue = deque()
    queue.append((i, j))
    v[i][j] = 1

    while queue:
        ci, cj = queue.popleft()
        # 네 방향 / 미방문 / 0 이상인 경우 bfs
        for di, dj in ((-1, 0), (0, -1), (1, 0), (0, 1)):
            ni, nj = ci + di, cj + dj
            if 0 < ni <= N and 0 < nj <= M and v[ni][nj] == 0 and arr[ni][nj] > 0:
                queue.append((ni, nj))
                v[ni][nj] = 1


def solve():
    for year in range(1, 900000):
        # [1] 네 방향에 대해 0 의 개수 카운트
        a_sub = [[0] * M for _ in range(N)]  # 0의 개수
        for i in range(1, N - 1):
            for j in range(1, M - 1):
                if arr[i][j] == 0:
                    continue
                for di, dj in ((-1, 0), (0, -1), (1, 0), (0, 1)):
                    ni, nj = i + di, j + dj
                    # 상하좌우 네
                    if arr[ni][nj] == 0:
                        a_sub[i][j] += 1

        # [2] 높이 낮추기
        for i in range(1, N - 1):
            for j in range(1, M - 1):
                # 빙하인 경우, 카운트한 0의 개수만큼 녹이기
                # 녹인 결과가 0 이하인 경우일 수 있으므로 max 사용
                if a_sub[i][j] > 0:
                    arr[i][j] = max(0, arr[i][j] - a_sub[i][j])

        # [3] 빙산 덩어리 개수 카운트 (feat.BFS)
        v = [[0] * M for _ in range(N)]
        sectionCount = 0
        for i in range(1, N - 1):
            for j in range(1, M - 1):
                if v[i][j] == 0 and arr[i][j] > 0:
                    bfs(i, j, v)
                    sectionCount += 1
        if sectionCount >= 2:
            return year
        if sectionCount == 0:
            return 0
    return -1


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
year = solve()
print(year)

"""
# bfs 에는 뭐가 들어가야 할까

def melt():
    for i in range(N):
        for j in range(M):
            if grid[N][M] > 0:
                grid[N][M] -= 1


def getYear():
    yearCount = 0
    while getSection() != 2:
        yearCount += 1
        melt()
    return yearCount

def getSection():
    sectionCount = 0
    visited = [[False * N for _ in range(M)]
    # 모든 인덱스에 대하여 방문여부와 수면위여부 확인,
    # BFS 를 통해 section 개수 카운트
    for i in range(N):
        for j in range(M):
            if not visited[i][j] and grid[i][j] > 1:
                bfs()
                sectionCount += 1
    return sectionCount

# - bfs
#     - 큐 선언 / 큐 <- 시작노드
#     - 4 방향의 이웃노드에 대해
#         - 범위 체크 : [0,M]
#         - vistied 체크
#         - 수면 위 여부 체크
#         - queue 에 이웃노드 추가
#         - visited[이웃노드i][이웃노드j] = True
from collections import deque
def bfs():
    queue = deque()

N, M = map(int, input().split())
grid = []
for i in range(N):
    grid.append(list(map(int, input().split())))
"""
