# 길이를 확정한 주식은 이후 계산에서 제외하기
def solution(prices):
    answer = [0] * len(prices)
    comparePriceIndexStack = [0]
    for i in range(1, len(prices)):
        while prices[comparePriceIndexStack[-1]] > prices[i]:
            j = comparePriceIndexStack.pop()
            answer[j] = i - j
        comparePriceIndexStack.append(i)
    while comparePriceIndexStack:
        j = comparePriceIndexStack.pop()
        answer[j] = len(prices) - 1 - j
    return answer


print(solution(prices=[1, 2, 3, 2, 3]))

# 값에 대해 비교를 통해 기간을 구해야할 때는 인덱스를 사용할 것
# ex)
# while prices[comparePriceIndexStack[-1]] > prices[i]:
#     j = comparePriceIndexStack.pop()
#     answer[j] = i - j
# loop 를 활용한 비교 시 , 비교대상을 제하고 싶다면 stack 을 사용하여 개선할 것
# ex)
# for i in range(1, len(prices)):
#     while prices[comparePriceIndexStack[-1]] > prices[i]:
#         j = comparePriceIndexStack.pop()
#         answer[j] = i - j
