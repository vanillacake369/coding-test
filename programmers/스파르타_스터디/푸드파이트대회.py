# 음식이 1개이하면 append, 1개 이상인 경우, 2로 나눈만큼 append
# 오른쪽 선수를 위해 역정렬 한 뒤, 0을 기준으로 concat
def solution(food):
    pl = []
    for i in range(1,len(food)):
        if(food[i] < 2):
            continue
        else:
            for j in range(0,food[i]//2):
                pl.append(str(i))
    answer =  "".join(pl) + "0" + "".join(list(reversed(pl)))
    return answer

# food = [1, 3, 4, 6]
# result = "1223330333221"
food = [1, 7, 1, 2]
result = "111303111"
print(solution(food) == result)
print(solution(food))
