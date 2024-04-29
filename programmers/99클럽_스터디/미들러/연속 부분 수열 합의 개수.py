def solution(elements):
    answer = set()
    for i in range(0, len(elements)):
        sum = 0
        for j in range(i, i + len(elements)):
            index = j % len(elements)
            sum += elements[index]
            answer.add(sum)

    return len(answer)


print(solution([7, 9, 1, 1, 4]))
