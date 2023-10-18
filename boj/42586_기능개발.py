# 두 배열을 통해 배열을 배포가능일 배열을 만들고
# // 남은 일수 / 스피드)반올림 == 배포가능일
# 배포가능일 배열에서
# 인덱스 순으로 루프를 돌며
# 배포기능카운트를 1로 초기화,
# 만약 이전 인덱스가 이후 인덱스보다 크다면 기능카운트+1,최대값으로 유지
# 이전 인덱스보다 이후 인덱스가 크다면 결과리스트에 추가, 이후 인덱스를 최대값으로 등극

import math


def solution(progresses, speeds):
    answer = []
    left = []
    for i in range(0, len(progresses)):
        l = math.ceil((100 - progresses[i]) / speeds[i])
        left.append(l)

    max = left[0]
    fcount = 0

    for i in left:
        if (i <= max):  # 배포일수 안에 배포가능
            fcount += 1
        else:  # 다음 배포일수인 경우
            answer.append(fcount)
            max = i
            fcount = 1
    answer.append(fcount)

    return answer


p1 = [93, 30, 55]
s1 = [1, 30, 5]
p2 = [95, 90, 99, 99, 80, 99]
s2 = [1, 1, 1, 1, 1, 1]

# print(solution(p1, s1))
print(solution(p2, s2))
