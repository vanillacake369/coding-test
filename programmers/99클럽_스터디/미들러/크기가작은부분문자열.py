from collections import deque


def solution(t, p):
    answer = 0
    slices = deque()
    pInt = int(p)
    for i in range(len(t)):
        if (i + len(p) <= len(t)):
            slices.append(int(t[i:i + len(p)]))
    slices = list(slices)  # deque 는 꼭 list 로 변환해주어야한다
    count = 0
    for slice in slices:
        if slice <= pInt:
            count += 1
    return count


print(solution(t="3141592", p="271"))
