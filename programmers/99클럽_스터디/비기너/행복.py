N = int(input())
scores = list(map(int, input().split()))
print(max(scores) - min(scores))
