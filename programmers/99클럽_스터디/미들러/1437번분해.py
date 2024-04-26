import sys

input = sys.stdin.readline

n = int(input())
dp = [0] * 100001
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 4

for i in range(5, n + 1):
    dp[i] = (dp[i - 3] * 3) % 10007
print(dp[n])
