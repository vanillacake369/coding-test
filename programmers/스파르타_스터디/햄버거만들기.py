def solution(ingredient):
    answer = 0
    stack = []
    for i in ingredient:
        stack.append(i)
        if(stack[len(stack)-4:len(stack)]) == [1,2,3,1]:
            answer += 1
            for i in range(0,4):
                stack.pop()
    return answer

ingredient = [2, 1, 1, 2, 3, 1, 2, 3, 1]	
result = solution(ingredient)
print(result)