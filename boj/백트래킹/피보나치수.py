n = int(input())
# n = 10
memo = [0] * (n + 2)
memo[0] = 0
memo[1] = 1
if n == 0 or n == 1:
    print(memo[n])
else:
    for i in range(0, n):
        memo[i + 2] = memo[i] + memo[i + 1]
    print(memo[n])
