def solution(numbers):
    answer = []
    cases = set()
    for i in range(0, len(numbers)):
        for j in range(i + 1, len(numbers)):
            cases.add(numbers[i] + numbers[j])

    return sorted(list(cases))
    return answer


numbers = [2, 1, 3, 4, 1]
result = [2, 3, 4, 5, 6, 7]
s = solution(numbers)
print(s)
# numbers = [5,0,2,7]
# result = [2,5,7,9,12]
# s = solution(numbers)
# print(s)
