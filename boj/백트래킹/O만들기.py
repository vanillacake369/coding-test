def getCalc(ans):
    tmp = ans.replace(' ', '')
    if eval(tmp) == 0:
        print(ans)


def select_operator(n, now, ans):
    if now == n + 1:
        getCalc(ans)
        return

    # 재귀호출
    select_operator(n, now + 1, ans + ' ' + str(now))
    select_operator(n, now + 1, ans + '+' + str(now))
    select_operator(n, now + 1, ans + '-' + str(now))


def solution(n):
    # https://westmino.tistory.com/47 참고
    """
    1~N 까지의 숫자들을 나열하고
    모든 장리에 '+', '-', ' ', 중 한 가지를 넣고
    eval() 을 통해 연산

    **eval() : 문자열로 된 수식을 계산 eg) eval('2+1') == 3
    """
    select_operator(n, 2, '1')
    print()


testCaseCount = int(input())
for _ in range(testCaseCount):
    solution(int(input()))
