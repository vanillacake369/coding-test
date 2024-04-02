# 음수를 가져다가 저장하여 비교해도 무관하다는 것을 이용한 풀이
# 조금 짧다,,,아니 많이,,,
def solution(survey, choices):
    answer = ''
    dic = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}

    for s, c in zip(survey, choices):
        if c > 4:
            dic[s[1]] += c - 4
        elif c < 4:
            dic[s[0]] += 4 - c

    li = list(dic.items())

    for i in range(0, 8, 2):
        if li[i][1] < li[i + 1][1]:
            answer += li[i + 1][0]
        else:
            answer += li[i][0]

    return answer

# ================== 아래는 내 풀이,,, 진짜 문제 그대로 구현,,, ==================

# def isLeftSide(choice):
#     if choice < 4:
#         return True
#     return False
#
#
# def getResultStrOf(dict):
#     dictValues = list(dict.values())
#     if dictValues[0] == dictValues[1]:
#         alphaBetAsc = list(sorted(dict.items(), key=lambda x: x[0]))
#         return alphaBetAsc[0][0]
#     else:
#         scoreDesc = list(sorted(dict.items(), key=lambda x: x[1], reverse=True))
#         return scoreDesc[0][0]
#
#
# def solution(survey, choices):
#     answer = ''
#     # R,T/F,C/M,J,/A,N
#     score = [0, 3, 2, 1, 0, 1, 2, 3]
#     dictAN = {'A': 0, 'N': 0}
#     dictRT = {'R': 0, 'T': 0}
#     dictCF = {'C': 0, 'F': 0}
#     dictMJ = {'M': 0, 'J': 0}
#     for idx, choice in enumerate(choices):
#         choiceScore = score[choice]
#         firstLetterOfEachSurvey = survey[idx][0]
#         secondLetterOfEachSurvey = survey[idx][1]
#         if firstLetterOfEachSurvey == 'A' or firstLetterOfEachSurvey == 'N':
#             if isLeftSide(choice):
#                 dictAN[firstLetterOfEachSurvey] += choiceScore
#             else:
#                 dictAN[secondLetterOfEachSurvey] += choiceScore
#         if firstLetterOfEachSurvey == 'R' or firstLetterOfEachSurvey == 'T':
#             if isLeftSide(choice):
#                 dictRT[firstLetterOfEachSurvey] += choiceScore
#             else:
#                 dictRT[secondLetterOfEachSurvey] += choiceScore
#         if firstLetterOfEachSurvey == 'C' or firstLetterOfEachSurvey == 'F':
#             if isLeftSide(choice):
#                 dictCF[firstLetterOfEachSurvey] += choiceScore
#             else:
#                 dictCF[secondLetterOfEachSurvey] += choiceScore
#         if firstLetterOfEachSurvey == 'M' or firstLetterOfEachSurvey == 'J':
#             if isLeftSide(choice):
#                 dictMJ[firstLetterOfEachSurvey] += choiceScore
#             else:
#                 dictMJ[secondLetterOfEachSurvey] += choiceScore
#     answer = getResultStrOf(dictRT) + getResultStrOf(dictCF) + getResultStrOf(dictMJ) + getResultStrOf(dictAN)
#     return answer
#
#
# print(solution(survey=["AN", "CF", "MJ", "RT", "NA"], choices=[5, 3, 2, 7, 5]))
# print(solution(survey=["TR", "RT", "TR"], choices=[7, 1, 3]))
