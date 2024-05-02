import heapq


def solution(k, score):
    scoreBoards = []
    answer = []
    for idx, s in enumerate(score):
        if len(scoreBoards) < k:
            heapq.heappush(scoreBoards, s)
        elif s > min(scoreBoards):
            heapq.heappop(scoreBoards)
            heapq.heappush(scoreBoards, s)
        answer.append(min(scoreBoards))
    return answer


k = 3
score = [10, 100, 20, 150, 1, 100, 200]
print(solution(k, score))
