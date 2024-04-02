def solution(k, tangerine):
    tangerineSet = dict()
    for t in tangerine:
        tangerineSet[t] = tangerineSet.get(t, 0) + 1
        # tangerineSet[t] = tangerine.count(t)
        # 이렇게 접근하면 시간초과 남
    tangerineDesc = sorted(tangerineSet.items(), key=lambda x: x[1], reverse=True)
    tangerineCount = 0
    for tangerineKeyValue in tangerineDesc:
        k -= tangerineKeyValue[1]
        tangerineCount += 1
        if k <= 0:
            break
    return tangerineCount


# print(solution(k=6, tangerine=[1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(k=4, tangerine=[1, 3, 2, 5, 4, 5, 2, 3]))
# print(solution(k=2, tangerine=[1, 1, 1, 1, 2, 2, 2, 3]))
