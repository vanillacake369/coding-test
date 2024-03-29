def solution(dirs):
    # U : +1y L : -1x R : +1x D : -1y
    # 0      1        2      3
    directionDict = {"U": 0, "L": 1, "R": 2, "D": 3}
    directionXY = [[0, 1], [-1, 0], [1, 0], [0, -1]]
    """ python 뽀인뜨
    [[0] * 11] * 11 은 모든 11 리스트들이 동일한 객체로 인식됨
    [[0] * 11 for _ in range(11)] 은 다름!!!!!!!
     """
    visited = set()
    x, y = 0, 0
    count = 0
    for d in dirs:
        # 다음 방문위치를 구한다
        nextX = x + directionXY[directionDict[d]][0]
        nextY = y + directionXY[directionDict[d]][1]
        # graph 를 벗어났다면 무시한다
        if nextX < -5 or nextX > 5 or nextY < -5 or nextY > 5:
            continue
        # 방문처리를 한다.
        if ((x, y, nextX, nextY) not in visited):
            # 여기가 문제의 핵심포인트!!!
            # 간선을 (a,b -> c,d) 를 표현하기 위해 (a,b,c,d) , (c,d,a,b) 를 저장!!
            visited.add((x,y,nextX,nextY))
            visited.add((nextX,nextY,x,y))
            count += 1
            # 좌표를 업데이트
        x = nextX
        y = nextY
    return count

answer = solution(dirs="ULURRDLLU")
# answer = solution(dirs="LULLLLLLU")
print(answer)
