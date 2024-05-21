"""
만들 수 있는 조합을 추출
조합의 숫자가 primeNumber 인지 판별
"""
import itertools


def isPrimeNum(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:  # i의 배수라면 소수 X
            return False
    return True


def solution(numbers):
    numberSplit = []
    for num in numbers:
        numberSplit.append(num)

    allCombi = []
    for i in range(1, len(numberSplit) + 1):
        combiNums = list(itertools.permutations(numberSplit, i))
        allCombi.append(combiNums)

    allCombiNums = set()
    for combiNum in allCombi:
        for combi in combiNum:
            tempStr = ""
            for c in combi:
                tempStr += c
            allCombiNums.add(int(tempStr))

    primeCount = 0
    for num in allCombiNums:
        if isPrimeNum(num):
            primeCount += 1
    return primeCount


print(solution("17"))
print(solution("011"))
