# https://school.programmers.co.kr/questions/43553?referer=collection-of-questions
# 반례 :: skip의 문자열이 연속된 문자열인 경우, 연속해서 더해주어야함

def solution(s, skip, index):
    answer = []
    skipMap = {}
    for sk in skip:
        skipMap.update({ord(sk):sk})
    for eachS in s:
        nextS = ord(eachS)
        i = index
        while i > 0:
            nextS += 1
            if(nextS > 122):
                nextS = 97
            if(skipMap.get(nextS)):
                i += 1
            i -= 1
        answer.append(chr(nextS))
    return "".join(answer)

s="z"
skip="abcdefghij"
index=20
result = solution(s,skip,index)
print(result)