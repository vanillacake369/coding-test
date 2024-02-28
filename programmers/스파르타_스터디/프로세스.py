# ====== deque 와 any 를 사용한 풀이 ======
def solution(priorities, location):
    queue = [(i, p) for i, p in enumerate(priorities)]
    answer = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == location:
                return answer


# ====== deque 와 max 를 사용한 풀이 ======

# from collections import deque

# def solution(priorities, location):
#     answer = 1
#     d = deque(priorities)  # 새로 배우는 문법 : 1) deque() 2) deque(list)
#     idx = location
#     while len(d) > 1:
#         tmp = d.popleft()
#         # 1. 현재 프로세스가 max 가 아닌 경우, deque에 다시 append
#         if tmp < max(d):  # 새로 배우는 문법 : max(deque)
#             d.append(tmp)
#             # 1-1. 만약 idx 가 0 인 경우,
#             if idx == 0:
#                 idx = len(d) - 1
#             # 1-2. 0이 아닌 경우, idx 를 감소
#             else:
#                 idx -= 1
#         # 2. 현재 프로세스가 max 인 경우
#         else:
#             # 2-1 현재 프로세스만 남은 경우라면 answer 반환
#             if idx == 0:
#                 return answer
#             # 2-2 deque에 아직 프로세스가 남아있다면 answer,idx 계산 이후 다음 루프 실행
#             else:
#                 answer += 1
#                 idx -= 1
#     return answer


# ---
# p = [2, 1, 3, 2]
# l = 2
p = [1, 1, 9, 1, 1, 1]
l = 0
result = solution(p, l)
print(result)
