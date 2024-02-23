# list 를 활용한 stack 
def solution(arr):
    answer = []
    for num in arr:
        if(len(answer) == 0 or num != answer[-1]):
            answer.append(num)
    return answer
arr = [1,1,3,3,0,1,1]	
result = solution(arr)
print(result)    


# 이전값 flag 와 list 를 사용한 풀이
# def solution(arr):
#     answer = []
#     previous = -1
#     for num in arr:
#         if num in answer:
#             if previous != num:
#                 answer.append(num)
#                 previous = num
#             else:
#                 continue
#         else:
#             previous = num
#             answer.append(num)
#     return answer
