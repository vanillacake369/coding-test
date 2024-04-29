"""
N 이 1000000 이라
그냥 O(N) 으로 풀어도 될 거 같지만
다른 방법은 없을까??
"""


def solution(n, m):
    answer = [1, 1]
    dividers = []
    # 최대공약수 랑 최소공배수를 따로 구하자
    # 최대 공약수
    minValue = min(n, m)
    maxValue = max(n, m)
    for i in range(minValue, 0, -1):
        if n % i == m % i == 0:
            answer[0] = i
            break
    for i in range(maxValue, n * m + 1):  # n * m 도 포함해야함 ㅇㅅㅇ
        if i % n == i % m == 0:
            answer[1] = i
            break  # 찾으면 바로 루프를 탈출해야함
    return answer


print(solution(1, 10))
