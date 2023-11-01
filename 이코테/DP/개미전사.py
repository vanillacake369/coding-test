n = int(input())
k = list(map(int, input().split()))

d = [0] * 103

# 본인 좌표에서의 최대치
# d[0]에 대해서는,,,
# d[0], d[0]+d[0+2], d[0]+d[0+2]+d[0+2+2]를 비교
for i in range(0, n):
    for j in range(0,2):
        d[i] = max(k[i], k[i]+k[j])

print(d)
print(max(d))
# 1 5 2 7
# 1,2 => 3
# 1,2,7 => 10
# 5,7 => 12
