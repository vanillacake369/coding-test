# 정답의 크기만큼 삼인방 답안지 형성
# 채점에 따라 dictionary에 사람번호:정답개수 update
# 정답개수를 key로 하여 dictionary 내림차순 정렬
# 정렬된 dictionary에서 사람번호 리스트 추출

def solution(answers):
    answer = []
    corrected = {}
    people = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    for i,p in enumerate(people):
        if(len(answers) > len(p)):
            rep = len(answers) // len(p) + 1
            p = p * rep
        cnt = 0
        for j in range(0,len(answers)):
            if(answers[j] == p[j]):
                cnt+=1
        if(cnt>0):
            corrected.update({i+1:cnt})
    maxCorrected = max(corrected.values())
    sortedAnswer = sorted(corrected.items(),key=lambda x: x[1],reverse=True)
    for s in sortedAnswer:
        if(s[1] == maxCorrected):
            answer.append(s[0])
    return answer

answers =  [3, 3, 3, 3, 2]
# answers = [1,2,3,4,5]	
# answers = [1,2,3,4,5,1,2,5,1,3,2,3,4]	
result = solution(answers)
print(result)