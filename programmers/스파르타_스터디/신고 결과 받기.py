# 더 효율적인 풀이 :: 유클리드 호제법
# https://question-answer.tistory.com/54

# def gcd(a, b):  # 최대공약수
#     for i in range(min(a, b), 0, -1):
#         if a % i == 0 and b % i == 0:
#             return i
#     return -1
# def solution(arr):
#     answer = 1
#     for i in arr:
#         answer = answer * i // gcd(answer, i) # 최소공배수 구하기
#     return answer

# 해당 접근의 오류
# 하나씩 늘려가면 다음 수와의 최대공약수를 찾을 때 제대로 된 값을 찾지 못 함
# 가령 2,3,7,8에 대하여 최대공약수들은 2,3,4인데 
# 하나씩 늘려서 찾다보니 2,3,7,8로 찾게됨
def solution(arr):
    arr.sort()
    lcm = 1
    lcm_start = 2
    for a in arr:
        if(lcm % a != 0):
            for i in range(lcm_start,a+1):
                if( (a % i == 0) ) :
                    lcm *= i
                    lcm_start = i+1
                    break
    return lcm
                
# arr = [2,7] #14
# arr = [2,6,8,14]	#168
# arr = [5,10,15,20,25]	#300
# arr =[12, 32, 45, 67, 72] #96480
# arr = [1,10,100,1000,5000,3,9999] #49995000
arr = [1,2,3,4,5,6,7,8,9,10] #2520
print(solution(arr))