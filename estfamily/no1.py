def solution(numbers):
    numberDict = dict()
    idxSet = set()

    for number in numbers:
        if number in numberDict:
            numberDict[number] += 1
        else:
            numberDict[number] = 1

    idx = 0
    count = 0
    while True:
        count += 1
        idx = numberDict[numbers[idx]]
        if idx in idxSet or idx >= len(numbers):
            break
        idxSet.add(idx)

    return count


# numbers = [1, 2, 3, 4, 5, 2, 3, 3, 4, 4, 4]
numbers = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
# numbers = [2, 2, 2, 2, 2]
print(solution(numbers))
