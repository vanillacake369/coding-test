def solution(arr):
    answer = []
    minValue = min(arr)
    for a in arr:
        if a != minValue:
            answer.append(a)
    if len(answer) == 0:
        answer.append(-1)
    return answer


print(solution([10]))
print(solution([4, 1, 3, 1, 2, 1, 1, 1]))
# 4 3 1 2 1 1 1 1 => 4 3 2 이걸 원하는 건가??
