# 명예의 전당 리스트가 k번째값이 있고, 다음 score가 k번째 값보다 크다면 k번째 값과 swap
# 그렇지 않다면 무시, 
# 이 중 최하위 값을 추출하여 발표점수 리스트에 저장
def solution(k, score):
    honor = []
    announce = []
    for i,sco in enumerate(score):
        if(k-1 >= i):
            honor.append(sco)
        elif(honor[k-1] < sco):
            honor.remove(honor[k-1])
            honor.append(sco)
        honor.sort(reverse=True)
        announce.append(min(honor))
    return announce

k = 3
score = [10, 100, 20, 150, 1, 100, 200]	
result = solution(k,score)
print(result)