"""
sorted 사용 풀이
<p>
틀린 이유
1. 메모리 부족 -> 몰랑 왜 틀림? ㅋㅋㅋ
N = int(input())
numbers = []
for _ in range(N):
    line = list(map(int, input().split()))
    for num in line:
        numbers.append(num)
descNumbers = sorted(numbers, key=lambda x: -x)
print(descNumbers[N - 1])
"""

"""
정답참고
<p>
코어 아이디어 : "N 크기의 최대값들만 추출"
<p>
- 우선순위 큐 안의 원소 개수가 N 개 미만 경우
    - 우선순위 큐에 입력값 삽입
- 우선순위 큐 안의 원소 개수가 N 개 초과 경우
    - 현재 입력값이 우선순위 큐의 최솟값보다 큰 경우 <- 최솟값을 계속 키워나감으로써 N 크기의 최대값 우선순위 큐 유지
        - 우선순위 큐 최솟값 제거
        - 현재 입력값을 우선순위 큐에 삽입
"""
"""
[12	7	9	15	5]
-> [5 7 9 12 15]

13 -> [7 9 12 13 15]
8 -> [8 9 12 13 15]
11 -> [9 11 12 13 15]
"""
import heapq

N = int(input())
numbers = []
for _ in range(N):
    eachLineNumbers = map(int, input().split())
    for eachNumber in eachLineNumbers:
        if len(numbers) < N:
            heapq.heappush(numbers, eachNumber)
        else:
            if numbers[0] < eachNumber:
                heapq.heappop(numbers)
                heapq.heappush(numbers, eachNumber)
print(numbers[0])
