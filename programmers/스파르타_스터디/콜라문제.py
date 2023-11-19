def solution(a, b, n):
    answer = 0
    k = n
    while(k>=a):
        # 가져갈 병수
        empt = k // a * a
        # 받은 병수
        given = empt // a * b
        # 가지고 있는 콜라 수
        k = k - empt + given
        # 받은 콜라와 가지고 있는 콜라 업데이트
        answer += given
    return answer


# a=2	
# b= 1	
# n=20	
# result = 19
a=3
b=1	
n=20	
result = 9
print(solution(a,b,n) == result)
print(solution(a,b,n))