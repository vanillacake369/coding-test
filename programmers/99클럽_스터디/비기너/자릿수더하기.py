def solution(n):
    answer = 0
    strN = str(n)
    for eachChar in strN:
        answer += int(eachChar)
    return answer


print(solution(123))
