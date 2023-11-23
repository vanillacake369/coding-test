import math
import itertools

def isPrime(x):
    for i in range(2,int(math.sqrt(x))+1):
        if x % i == 0:
            return False
    return True

# 숫자합 조합 중 소수의 개수를 구하기
def solution(nums):
    p = []
    cnt = 0
    for i in itertools.combinations(nums,3):
        p.append(sum(i))
    for i in p:
        if isPrime(i):
            cnt += 1
    return cnt

nums = [1,2,3,4]
print(solution(nums))