def solution(s):
    answer = []
    mem = {}
    for i in range(0,len(s)):
        if((s[i] in mem) == False):
            answer.append(-1)
            mem[s[i]] = i
        else:
            diff = i - mem[s[i]]
            answer.append(diff)
            mem[s[i]] = i

    return answer

s = "banana"	
print(solution(s))