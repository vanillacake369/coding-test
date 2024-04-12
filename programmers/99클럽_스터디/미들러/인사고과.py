def solution(scores):
    # 원호에 대해 저장한 뒤, 점수들을 정렬 이후 각각의 점수와 비교하여 원호의 순위를 찾는다.
    wanho = scores[0]
    wanhoScore = scores[0][0] + scores[0][1]
    sortedScores = sorted(scores, key=lambda x: (-x[0], x[1]))
    temp = 0
    seq = 1
    for eachScore in sortedScores:
        # 완호가 인센티브를 받지 못 하는 경우
        if wanho[0] < eachScore[0] and wanho[1] < eachScore[1]:
            return -1
        # 완호의 석차 구하기
        # temp 를 통해 동석차 처리
        if wanhoScore < eachScore[0] + eachScore[1] and temp <= eachScore[1]:
            seq += 1
            temp = eachScore[1]
    return seq


scores = [[2, 2], [1, 4], [3, 2], [3, 2], [2, 1]]
print(solution(scores))
