from itertools import permutations

N, M = map(int, input().split())
cards = list(map(int, input().split()))
# N, M = 5, 21
# cards = [5, 6, 7, 8, 9]
# N, M = 10, 500
# cards = [93, 181, 245, 214, 315, 36, 185, 138, 216, 295]
allPossibleCards = list(permutations(cards, 3))
maxSum = 0
for eachPossibleCards in allPossibleCards:
    sumOfPC = sum(eachPossibleCards)
    if sumOfPC <= M:
        maxSum = max(maxSum, sumOfPC)
print(maxSum)
