# N^2 으로 시간초과 발생
# def solution(n, left, right):
#     answer = []
#     for i in range(1, n + 1):
#         for j in range(1, n + 1):
#             if j <= i:
#                 answer.append(i)
#             else:
#                 answer.append(j)
#     return answer[left:right + 1]

# 각 인덱스에 대해서 -> n 으로 나눈 몫과 나머지 중 최대값
def solution(n, left, right):
    answer = []

    for i in range(left, right + 1):
        answer.append(max(i // n, i % n) + 1)

    return answer


# n = 3
# left = 2
# right = 5
# result = [3, 2, 2, 3]
n = 4
left = 7
right = 14
result = [4, 3, 3, 3, 4, 4, 4, 4]
print(solution(n, left, right))
