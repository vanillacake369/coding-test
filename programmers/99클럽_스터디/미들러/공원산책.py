def isValidPath(d, vStr, direction, grid, startRow, startCol):
    v = int(vStr)
    nextR = startRow
    nextC = startCol
    for i in range(v):
        nextR += direction[d][0]
        nextC += direction[d][1]
        # 공원 밖
        if nextR > len(grid) - 1 or nextR < 0 or nextC > len(grid[0]) - 1 or nextC < 0:
            return False
        # 장애물 지난 경우
        if grid[nextR][nextC] == 1:
            return False
    return True


def solution(park, routes):
    # [][] 생성
    grid = [[0 for _ in range(len(park[0]))] for _ in range(len(park))]
    # 문자열에 대해 S -> 시작점, O -> 0, X -> 1 표시
    startRow = 0
    startCol = 0
    for i, parkStr in enumerate(park):
        for j, parkChar in enumerate(parkStr):
            if parkChar == "S":
                startRow = i
                startCol = j
            if parkChar == "X":
                grid[i][j] = 1
                continue
    print(grid)
    direction = {
        "E": [0, 1],
        "S": [1, 0],
        "W": [0, -1],
        "N": [-1, 0]
    }
    # routes 를 순회하며 각 route 에 대해
    # 현재 좌표에서 이동처리한 다음좌표에 대한 검증 작업 처리 :
    # 1) 공원 벗어나는지
    # 2) 이동 중 장애물 있는지
    # 검증 통과 시 현재 좌표 <- 다음좌표
    for route in routes:
        d, vStr = route.split()
        if isValidPath(d, vStr, direction, grid, startRow, startCol):
            startRow += direction[d][0] * int(vStr)
            startCol += direction[d][1] * int(vStr)

    # routes 순회 이후 최종 좌표 반환
    return [startRow, startCol]


park = ["OSO", "OOO", "OXO", "OOO"]
routes = ["E 2", "S 3", "W 1"]
print(solution(park, routes))
