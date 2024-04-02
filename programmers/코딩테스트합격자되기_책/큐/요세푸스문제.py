n, k = map(int, input().split())
from collections import deque


def solution(n, k):
    queue = deque()
    for i in range(1, n + 1):
        queue.append(i)
    while len(queue) > 1:
        for i in range(k - 1):
            queue.append(queue.popleft())
            queue.popleft()
    return queue[0]


print(solution(n, k))

# 아래 풀이는 시간초과가 발생한다.
# def solution(n, k):
# perm = []
# eliminated = []
#
# now = 0
# for i in range(n):
#     count = 0
#     while count < k:
#         if not now in eliminated:
#             count += 1
#         if count < k:
#             now = (now + 1) % n
#     perm.append(now + 1)
#     eliminated.append(now)
#
# print("<", ", ".join(map(str, perm)), ">", sep='')

solution(n, k)
