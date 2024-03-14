def solution(array, commands):
    answer = []
    for command in commands:
        sortedArr = sorted(array[command[0]-1 : command[1]])
        answer.append(sortedArr[command[2] - 1])
    return answer

arr = [1, 5, 2, 6, 3, 7, 4]
com = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
result = solution(arr, com)
print(result)
