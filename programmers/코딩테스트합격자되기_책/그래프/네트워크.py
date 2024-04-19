def dfs(n, computers, com, visited):
    visited[com] = True
    for connect in range(n):
        if computers[com][connect] == 1 and not visited[connect]:  # 연결된 컴퓨터라면(값이 1인 경우) dfs 처리
            dfs(n, computers, connect, visited)


def solution(n, computers):
    answer = 0
    visited = [False for _ in range(n)]
    for i in range(n):
        if not visited[i]:
            dfs(n, computers, i, visited)  # dfs 처리 이후 탈출하면 하나의 그룹이 처리됨
            answer += 1  # 그룹 카운트
    return answer


n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
print(solution(n, computers))
