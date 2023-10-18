import sys


def bin_search(parts, data, start, end):
    if (start > end):
        return False

    mid = (start + end) // 2
    if (parts[mid] == data):
        return True

    elif (parts[mid] > data):
        return bin_search(parts, data, start, mid-1)

    else:
        return bin_search(parts, data, mid+1, end)


# 매장 부품 리스트
n = int(sys.stdin.readline().rstrip())
parts = list(map(int, sys.stdin.readline().rstrip().split()))

parts.sort()

# 찾고자 하는 부품 리스트
m = int(sys.stdin.readline().rstrip())
target = list(map(int, sys.stdin.readline().rstrip().split()))

result = []
for i in target:
    if (bin_search(parts, i, 0, n-1)):
        result.append("yes")
    else:
        result.append("no")


print(result)
