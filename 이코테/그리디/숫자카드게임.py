# 각 행에 대한 최소값을 찾고, 이 중 최대값을 찾는다.
n,m = map(int,input().split(" "))
cards = [ 0 ] * n
# cards = [[0] * m] * n

for i in range(0,n):
    cards[i] = list(map(int,input().split(" ")))

result = []
for i in range(0,n):
    result.append(min(cards[i]))
print(max(result))