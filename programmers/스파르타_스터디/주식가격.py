from collections import deque

# 1) queue 를 활용한 for loop 두 번 쓰기
def solution(prices):
    answer = []
    priceQueue = deque(prices)

    while priceQueue:
        price = priceQueue.popleft()
        flag = 0
        for p in priceQueue:
            flag += 1
            if price > p:
                break
        answer.append(flag)
    
    return answer