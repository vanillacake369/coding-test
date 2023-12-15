def solution(s):
    answer = []
    stmp = s
    loopCnt = 0
    zeroCntSum = 0
    while(len(stmp) != 1):
        loopCnt += 1
        zeroCnt = 0
        for ss in stmp:
            if (ss == '0'):
                zeroCnt+=1
        zeroCntSum += zeroCnt
        stmp = bin(len(stmp)-zeroCnt)[2:]
    answer.append(loopCnt)
    answer.append(zeroCntSum)
    return answer

s = "110010101001"
result = solution(s)
print(result)