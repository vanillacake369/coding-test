def solution(topping):
    answer = 0
    # 철수 케이크
    bro1 = {}
    for t in topping:  # O(N) 각각의 토핑들의 Count -> {토핑값 : 토핑 Count}
        if t in bro1:
            bro1[t] += 1
        else:
            bro1[t] = 1

    # 동생 케이크
    bro2 = {}
    for t in topping:
        # 둘의 딕셔너리 크기가 같다면 동일한 크기로 나눈 것이므로 answer += 1
        if len(bro1) == len(bro2):
            answer += 1
        # 동생 케이크에 해당 토핑이 없다면 토핑 추가
        if t not in bro2:
            bro2[t] = 1

        # 철수 토핑에서 토핑 Count 빼주기
        bro1[t] -= 1
        # 철수가 이제 토핑을 가지고 있지 않다면 dict 에서 제거
        if bro1[t] == 0:
            del bro1[t]

    return answer


topping = [1, 2, 1, 3, 1, 4, 1, 2]
print(solution(topping))
