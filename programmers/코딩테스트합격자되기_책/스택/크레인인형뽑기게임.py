def solution(board, moves):
    stacks = [[] for _ in range(len(board[0]))]
    bucket = []
    popCount = 0
    for i in range(len(board) - 1, -1, -1):
        for j in range(len(board[0])):
            if board[i][j]:
                stacks[j].append(board[i][j])
    for i in range(len(moves)):
        if stacks[moves[i] - 1]:
            picked = stacks[moves[i] - 1].pop()
            if (bucket and bucket[-1] == picked):
                popCount += 2
                bucket.pop()
            else:
                bucket.append(picked)
    return popCount


board = [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]]
moves = [1, 5, 3, 5, 1, 2, 1, 4]
print(solution(board, moves))
