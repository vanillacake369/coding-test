x = int(input())

d = [0] * 30001 # 입력값이 1~30000이므로 30001까지

for i in range(2, x+1):
    # 1을 빼는 경우를 제외하고 점화식으로 접근 
    # -> 1을 빼는 경우와 각각으로 나누어 접근하는 경우 중 최소값 비교
    d[i] = d[i-1] + 1 

    if i % 2 == 0 :
        d[i] = min(d[i],d[i//2]+1)
    if i % 3 == 0 :
        d[i] = min(d[i],d[i//3]+1)
    if i % 5 == 0 :
        d[i] = min(d[i],d[i//5]+1)


print(d[x])