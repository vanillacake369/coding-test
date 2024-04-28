# sorted() => O(n * log(n))
import sys

input = sys.stdin.readline

N = int(input())
products = dict()
for i in range(0, N):
    quality, price = map(int, input().split())
    products[i] = (quality, price)
firstSelection = list(dict(list(sorted(products.items(), key=lambda x: (-x[1][0], x[1][1])))).values())
secondSelection = list(dict(list(sorted(products.items(), key=lambda x: (x[1][1], -x[1][0])))).values())
print(str(firstSelection[0][0]) + ' ' + str(firstSelection[0][1]) + ' ' + str(firstSelection[1][0]) + ' ' +
      str(firstSelection[1][1]))
print(str(secondSelection[0][0]) + ' ' + str(secondSelection[0][1]) + ' ' + str(secondSelection[1][0]) + ' ' +
      str(secondSelection[1][1]))
# print(
#     ' '.join(
#         list(map(str, [firstSelection[0][0], firstSelection[0][1], firstSelection[1][0], firstSelection[1][1]]))))
# print(
#     ' '.join(
#         list(map(str, [secondSelection[0][0], secondSelection[0][1], secondSelection[1][0], secondSelection[1][1]]))))
