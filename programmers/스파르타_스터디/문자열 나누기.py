# 이렇게는 왜 안 풀릴까???
# 아직까지도,,,해당 방식으로는 미구현,,,!
# 2023-12-01
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
                answer += 1
                isX = 0
                isNotX = 0
                i = j
                break
    return answer+1

s = "banana"
print(solution(s))
    