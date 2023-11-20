# 주어진 name을 만들 수 있는 모든 경우의 조작횟수 중 최소값
def solution(name):
    nameL = list(name)
    dL = ['A'] * len(nameL)

    for i in range(0, len(dL)):
        print(ord(nameL[i]) - ord(dL[i]))

    answer = 0
    return answer


name = "JAZ"
print(solution(name))
