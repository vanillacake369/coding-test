# https://school.programmers.co.kr/questions/33347
# 수학 못 하면 서러워서 개발자 하겠냐,,,,ㅠㅠ

def solution(clothes):
    answer = 1
    clothes_kind = {}
    for cl in clothes:
        if(cl[1] in clothes_kind):
            clothes_kind[cl[1]] += 1
        else:
            clothes_kind[cl[1]] = 1
    for k in clothes_kind:
        answer *= (1+clothes_kind[k])
    return answer - 1
    