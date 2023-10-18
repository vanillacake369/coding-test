import sys

n, l = map(int, sys.stdin.readline().split())


def getAnswer(n, l):
    result = []

    # 수열 구하기
    for i in range(l, 101):
        m = n - (i*(i-1)/2)
        if (m % i == 0 and m // i >= 0):  # 수열인 경우
            a = m / i
            for j in range(0, i):
                result.append(int(a+j))
            break

    if (len(result) > 0):
        return result
    return -1


answer = getAnswer(n, l)
if (isinstance(answer, list)):
    for i in answer:
        print(i, end=" ")
else:
    print(answer)
