def solution(s):
    sList = list(map(int, s.split()))
    minMax = [min(sList), max(sList)]
    return " ".join(map(str, minMax))


print(solution("1 2 3 4"))
print(solution("-1 -2 -3 -4"))
print(solution("-1 -1"))
