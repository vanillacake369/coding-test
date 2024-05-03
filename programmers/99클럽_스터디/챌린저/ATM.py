N = int(input())
waitTimes = list(map(int, input().split()))
ascWaitTimes = sorted(waitTimes)
sumWaitTime = 0
for i in range(0, N + 1):
    sumWaitTime += sum(ascWaitTimes[:i])
print(sumWaitTime)
