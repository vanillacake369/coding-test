# 이 풀이는 시간초과가 난다.
def solution(ingredient):
    answer = 0
    tempIngredient = []
    burger = [1, 2, 3, 1]
    for i in ingredient:
        tempIngredient.append(i)
        if len(tempIngredient) >= 4 and tempIngredient[-4:] == burger:
            del tempIngredient[-4:]
            answer += 1
    return answer


# 이 풀이는 시간초과가 안 난다.
# def solution(ingredient):
#     answer = 0
#     stack = []
#     for i in ingredient:
#         stack.append(i)
#         if(stack[len(stack)-4:len(stack)]) == [1,2,3,1]:
#             answer += 1
#             for i in range(0,4):
#                 stack.pop()
#     return answer

print(solution(ingredient=[2, 1, 1, 2, 3, 1, 2, 3, 1]))
