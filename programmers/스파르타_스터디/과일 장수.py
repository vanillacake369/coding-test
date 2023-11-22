# 역순정렬을 한다
# k점수 이하의 사과 중 최대값의 사과 m개를 추출한다.
# 각 박스 별 점수를 합한다.
def solution(k, m, score):
    answer = 0
    score.sort(reverse = True)
    for i in range(0,len(score),m):
        box = score[i:i+m]
        if len(box) == m:
            answer += min(box) * m
    return answer

k = 3
m = 4
score = [1, 2, 3, 1, 2, 3, 1]	
result = solution(k,m,score)
print(result)