# 지문 이해도가 굉장히 중요한 문제,,,
# 팩트만 이해하자,,,괜히 상상력을 넣지 말고,,,ㅠㅠ
def solution(s):
    answer = 0
    isX = 0
    isNotX = 0
    for i in range(0,len(s)):
        x = s[i]
        for j in range(i,len(s)):
            if x == s[j]:
                isX += 1
            else:
                isNotX += 1
            if (isX > 0) and (isX == isNotX):
                print("same")
                answer += 1
                s = s[:i+1]
                isX = 0
                isNotX = 0
                # if(j != len(s)-1):
                #     i = j
                break
    return answer

s = "banana"
print(solution(s))
    