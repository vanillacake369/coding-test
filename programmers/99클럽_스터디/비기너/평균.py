"""
각 점수 / 최대값 * 100
"""

N = int(input())
scores = list(map(int, input().split()))
maxScore = max(scores)
sumScore = 0
for i, score in enumerate(scores):
    sumScore += scores[i] / maxScore * 100
print(sumScore / N)
