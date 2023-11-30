def solution(lottos, win_nums):
    answer = []
    seq = [6,6,5,4,3,2,1]
    cnt = 0
    zero_cnt = 0
    for l in lottos:
        if(l == 0):
            zero_cnt += 1
    for w in win_nums:
        if(w in lottos):
            cnt += 1
    answer.append(seq[cnt+zero_cnt])
    answer.append(seq[cnt])
    return answer

lottos = [44, 1, 0, 0, 31, 25]	
win_nums = [31, 10, 45, 1, 6, 19]	
result =solution(lottos,win_nums)
print(result)