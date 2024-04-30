"""
첫 번째 줄의 색이 정해지면 다음 줄의 색은 첫번째줄의색 이외의 색 중 최소비용인 것으로 정해짐
e.g. 1:R -> 2:min(2:G,2:B)
minCostOfR = 1:R 선택했을 때 비용들 중 최소값  
minCostOfG = 1:G 선택했을 때 비용들 중 최소값  
minCostOfB = 1:B 선택했을 때 비용들 중 최소값
answer = min(minCostOfR, minCostOfG, minCostOfB)
print(answer)  
"""
"""
그리디로 접근하면 안 되는 이유!!!

전체 경우의 최선 != 다음 탐색의 최선
eg) 1->100->1 의 경우 vs 1->2->100000 의 경우 :: 그리디로 접근하면 후자를 선택하게 됨.
"""
"""
N = int(input())
colorCosts = []
for _ in range(N):
    colorCosts.append(list(map(int, input().split())))
minCostOfR = 0
minCostOfG = 0
minCostOfB = 0


def getMinCostOfStartBy(colorCosts, color, depth):
    if depth == len(colorCosts) - 1:
        return colorCosts[depth][color]

    nextColor = (color + 1) % 3
    nextNextColor = (color + 2) % 3

    # minColor 찾아서 다음 탐색 색깔로 인자넘기기
    minColor = 0
    if colorCosts[depth + 1][nextColor] < colorCosts[depth + 1][nextNextColor]:
        minColor = nextColor
    else:
        minColor = nextNextColor

    return colorCosts[depth][color] + getMinCostOfStartBy(colorCosts, minColor, depth + 1)


minCostOfR = getMinCostOfStartBy(colorCosts, 0, 0)
minCostOfG = getMinCostOfStartBy(colorCosts, 1, 0)
minCostOfB = getMinCostOfStartBy(colorCosts, 2, 0)

print(minCostOfR)
print(minCostOfG)
print(minCostOfB)

minCostOfAll = min(minCostOfR, minCostOfG, minCostOfB)
print(minCostOfAll)
"""

"""
N 의 최선 = N번째 줄의 최선 + 1~N-1까지의 최선
이를 DP 를 통해 각각의 인덱스에 대한 최선값 저장하여 비교하자
"""
n = int(input())
a = [0] * n

for i in range(n):
    a[i] = list(map(int, input().split()))

for i in range(1, n):  # 1부터 시작하는 이유는 다음 입력값이 이전 입력값의 최소값을 사용하기때문이다
    a[i][0] = min(a[i - 1][1], a[i - 1][2]) + a[i][0]
    a[i][1] = min(a[i - 1][0], a[i - 1][2]) + a[i][1]
    a[i][2] = min(a[i - 1][0], a[i - 1][1]) + a[i][2]

print(min(a[n - 1][0], a[n - 1][1], a[n - 1][2]))
