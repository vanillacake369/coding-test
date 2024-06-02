N = int(input())
V = []
temp = input().split(" ")

for i in range(N - 1, -1, -1):
    V.append(int(temp[i]))

answer = 1
cur_speed = 1

for i in range(1, N):

    if V[i] > cur_speed:
        cur_speed += 1
    else:
        cur_speed = V[i]
        
    answer += cur_speed

print(answer)
