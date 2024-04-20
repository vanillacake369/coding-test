"""
다음 숫자가 이전 숫자보다 크다면 현재숫자 pop
다음 숫자가 이전 숫자보다 같거나 작다면 다음 숫자 append
스택에서 pop 한 카운트가 k라면 pop 그만하고 append
"""


def solution(number, k):
    answer = ''
    numberList = list(map(int, number))
    numberStack = []

    for idx, eachNumber in enumerate(numberList):
        while k > 0 and len(numberStack) > 0 and numberStack[-1] < eachNumber:
            numberStack.pop()
            k -= 1
        numberStack.append(eachNumber)

    # 반례) 동일한 수가 있는 경우 -> k 가 아직 0이 아니므로 k 만큼 slicing
    if k > 0:
        numberStack = numberStack[:-k]

    return ''.join(list(map(str, numberStack)))


# 4177252841
# 477252841
# 47752841
# 7752841

# 4177252841
# 477252841
# 47725284
# 4772584 -> 순서가 그대로 유지되는 거구만 ㅇㅅㅇ


# solution("1924", 2)
# print(solution("4177252841", 4))
print(solution("7777777", 2))
