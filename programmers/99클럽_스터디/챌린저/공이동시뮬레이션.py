def solution(n, m, x, y, queries):
    # 상쇄되는 이동끼리 상쇄
    # 상쇄되지 않는 방향에 대해서 좌표를 추출 e.g. 3([1][0]) 이 세 번이면 [-3][0] 범위의 좌표 찾기
    # 해당 범위의 넓이를 계산
    # 증가라면 max 를 증가, 감소라면 min 을 감소시켜서 범위를 측정
    backTraceDirection = {0: [0, 1], 1: [0, -1], 2: [1, 0], 3: [-1, 0]}
    reversedQueries = reversed(queries)
    xMin = x
    xMax = x
    yMin = y
    yMax = y
    for d, s in reversedQueries:
        dx = backTraceDirection[d][0] * s
        dy = backTraceDirection[d][1] * s
        if d == 0:
            yMax += dy
            if yMax > m - 1:
                yMax = m - 1
            # 왼쪽 yMin 이 끝이 아니라면 범위 축소
            # -> 왜냐하면 max 가 이동함에 따라 min 또한 이동시켜 범위를 그대로 옮겨야 하기 때문
            if yMin != 0:
                yMin += dy
        if d == 1:
            yMin += dy
            if yMin < 0:
                yMin = 0
            # 범위 축소
            # -> 왜냐하면 max 가 이동함에 따라 min 또한 이동시켜 범위를 그대로 옮겨야 하기 때문
            if yMax != m - 1:
                yMax += dy
        if d == 2:
            xMax += dx
            if xMax > n - 1:
                xMax = n - 1
            # 범위 축소
            # -> 왜냐하면 max 가 이동함에 따라 min 또한 이동시켜 범위를 그대로 옮겨야 하기 때문
            if xMin != 0:
                xMin += dx
        if d == 3:
            xMin += dx
            if xMin < 0:
                xMin = 0
            # 범위 축소
            # -> 왜냐하면 max 가 이동함에 따라 min 또한 이동시켜 범위를 그대로 옮겨야 하기 때문
            if xMax != n - 1:
                xMax += dx
    if xMin > n - 1 or xMax < 0 or yMin > m - 1 or yMax < 0:
        return 0
    return (xMax - xMin + 1) * (yMax - yMin + 1)


n = 2
m = 2
x = 0
y = 0
queries = [[2, 1], [0, 1], [1, 1], [0, 1], [2, 1]]
print(solution(n, m, x, y, queries))
