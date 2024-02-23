# 이전값 flag 와 list 를 사용한 풀이
def solution(arr):
    answer = []
    previous = -1
    for num in arr:
        if num in answer:
            if previous != num:
                answer.append(num)
                previous = num
            else:
                continue
        else:
            previous = num
            answer.append(num)
    print(answer)
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print('Hello Python')
    return answer

arr = [1,1,3,3,0,1,1]	
result = solution(arr)
print(result)    