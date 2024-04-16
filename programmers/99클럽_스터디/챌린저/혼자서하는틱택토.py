# 틀린 풀이,,,
# 가로줄, 세로줄 판단 시 0,1,2 순서대로 없어도 맞다고 나옴,,,

def isWon(dol):
    rows = [row for row, _ in dol]
    cols = [col for _, col in dol]
    # 가로줄, 세로줄 판단
    if 0 in sorted(rows) and 1 in sorted(rows) and 2 in sorted(rows):
        return True
    if 0 in sorted(cols) and 1 in sorted(cols) and 2 in sorted(cols):
        return True
    # 대각선 판단
    if (0, 0) in dol and (1, 1) in dol and (2, 2) in dol:
        return True
    if (0, 2) in dol and (1, 1) in dol and (2, 0) in dol:
        return True
    return False


def solution(board):
    o = []
    x = []
    rowCurrent = 0
    colCurrent = 0
    for eachBoard in board:
        for eachDol in eachBoard:
            if eachDol == "O":
                o.append((rowCurrent, colCurrent))
            if eachDol == "X":
                x.append((rowCurrent, colCurrent))
            colCurrent += 1
        colCurrent = 0
        rowCurrent += 1

    o_count, x_count = len(o), len(x)

    # O와 X의 개수 검사
    if not (o_count == x_count or o_count == x_count + 1):
        return 0

    rows = [row for row, _ in o]
    cols = [col for _, col in o]
    sub_rows_len = len(rows)
    for i in range(len(rows) - sub_rows_len + 1):
        if rows[i:i + sub_rows_len] == rows:
            print(rows[i:i + sub_rows_len])
            print(rows)
    sub_cols_len = len(cols)
    for i in range(len(cols) - sub_cols_len + 1):
        if cols[i:i + sub_cols_len] == cols:
            print(cols[i:i + sub_cols_len])
            print(cols)

    if isWon(o) and isWon(x):
        return 0

    if isWon(o) and o_count != x_count + 1:
        return 0

    if isWon(x) and o_count != x_count:
        return 0

    return 1


# board = ["O.X", ".O.", "..X"]
# 1
# board = ["OOO", "...", "XXX"]
# 0
# board = ["...", ".X.", "..."]
# 0
# board = ["...", "...", "..."]
# 1
# board = ["O.X", "O.X", "O.."]
# 1
# board = ["OOO", "OOX", "XXX"]
# 0
# board = ["XXX", "...", "OOO"]
# 0
board = ["OOO", "XOX", "XXO"]
# 1
print(solution(board))

# 테스트 6,12,13,20,22,23,28,42,47
