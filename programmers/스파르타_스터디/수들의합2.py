# 순열 조합으로 꼼수 쓰기 안 되네 ㅎㅎ (서로 다른 경우의 수라 판별 X)

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
# N, M = 10, 5
# numbers = [1, 2, 3, 4, 2, 5, 3, 1, 1, 2]
# N, M = 4, 2
# numbers = [1, 1, 1, 1]
"""
1 2 3 4 2 5 3 1 1 2

1) 1 1 1 2
2) 2 3
3) 5

X) 1 4 => 수열이라 불가능. 잉 애초에 이게 정답이 아니네 ㅋㅎㅋㅋㅎ
"""
"""
인덱스에 대해 포인터 i, j 생성
sum(numbers[i:j]) 을 구하여 M 과 비교
같다면 count += 1
"""

i = 0
j = 1
count = 0
while i <= j and j <= N:
    sumFromIToJ = sum(numbers[i:j])
    if sumFromIToJ == M:
        count += 1
        j += 1
    if sumFromIToJ > M:
        i += 1
    if sumFromIToJ < M:
        j += 1
print(count)
