from collections import deque

# 2) stack 을 활용하여 남아있는 이전값들을 비교하기
def solution(prices):
    answer = []

    # 모든 price 가 떨어지지는 않은 경우로 초기화
    answer = [ i for i in range (len(prices) - 1, -1, -1)]
    
    # stack 정의
    stack = [0]

    # prices 를 순회
    for i in range(1,len(prices)):
        # stack 내 원소 존재 & stack 의 top 인덱스의 price 보다 현재값이 작다면
        while stack and prices[stack[-1]] > prices[i]:
            # 아래를 통해 주식가격이 떨어진 기간만큼을 연산한다.
            # stack 의 top 인덱스의 price = 현 인덱스 - top 인덱스
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)

    return answer


# 1) queue 를 활용한 for loop 두 번 쓰기
# def solution(prices):
#     answer = []
#     priceQueue = deque(prices)

#     while priceQueue:
#         price = priceQueue.popleft()
#         flag = 0
#         for p in priceQueue:
#             flag += 1
#             if price > p:
#                 break
#         answer.append(flag)
    
#     return answer