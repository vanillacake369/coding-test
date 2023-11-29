import math

def solution(number, limit, power):
    divNums = []                             # 약수 list
    for i in range(1, number+1):              # 1부터 number까지 for loop
        d = 0
        for j in range(1, int(math.sqrt(i)) + 1): # 1부터 i의 제곱근까지 for loop
            if i % j == 0:
                d += 1
                if j**2 != i:                 # 제곱이 되는 수는 count 1을 하여 중복 방지.
                    d += 1
            if d > limit:               # limit값을 초과하면 power값으로 return
                d = power
                break
        divNums.append(d)
    return sum(divNums)