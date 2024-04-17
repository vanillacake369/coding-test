n, r, c = map(int, input().split())
# n, r, c = 2, 3, 1
# n, r, c = 3, 7, 7
"""
1/4 씩 줄여나가자
1/4 씩 줄인 값 + r,c 에 해당하는 추가값
** r,c 에 해당하는 추가값 <- 2 * row * col
    ** row : row % 2 , col : col % 2 
"""


def recursive(n, row, col):
    if n == 0:
        return 0
    curRow = row % 2
    curCol = col % 2
    rcPlus = 2 * curRow + curCol
    return 4 * recursive(n - 1, row // 2, col // 2) + rcPlus


print(recursive(n, r, c))
