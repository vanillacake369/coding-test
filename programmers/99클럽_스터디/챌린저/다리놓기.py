T = int(input())


# F(N,M) = F(N-1,1) + F(N-1,2) + ,, + F(N-1,M-1)
def getBridgeCount(N, M):
    dp = [[1 for _ in range(M + 1)] for _ in range(M + 1)]

    for i in range(1, M + 1):
        dp[1][i] = i

    for i in range(2, N + 1):
        for j in range(i + 1, M + 1):
            dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]

    return dp[N][M]


for _ in range(T):
    N, M = map(int, input().split())
    print(getBridgeCount(N, M))
