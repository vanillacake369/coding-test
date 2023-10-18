import sys


def sum_diffs(arr, cut):  # 리스트를 순환하며 차이의 합을 반환
    sum = 0
    for i in arr:
        if (i >= cut):
            sum += (i - cut)
    return sum


input = sys.stdin.readline

# n : 떡 개수 / m : 떡 리스트 / cutters : 절단기 후보 리스트
n, m = map(int, input().split(' '))
cutters = []

# 떡 입력
rc = list(map(int, input().split()))

# 떡 오름차순 정렬
rc.sort()


# 절단기 높이 :: 가장 작은 길이의 떡, 큰 길이의 떡 사이에서 이진탐색
# start = rc[0] ===> 이건 시작점을 잘못 잡았고
start = 0
# end = n-1 ===> 이건 인덱스의 값으로 두었어야 했는데 인덱스로 두어버림
end = rc[n-1]

# while (start <= end):
#     mid = (start+end) // 2
#     sum = sum_diffs(rc, mid)

#     # 만약 원하는 길이가 나왔다면 절단기 리스트에 추가
#     if (sum == m):
#         cutters.append(mid)

#     elif (sum < m):
#         end = mid - 1

#     else:
#         cutters.append(mid)
#         start = mid + 1
while (start <= end):
    mid = (start+end) // 2
    sum = sum_diffs(rc, mid)

    if (sum == m):
        cutters.append(mid)
        break

    elif (sum < m):
        end = mid - 1

    else:
        start = mid + 1

# 절단기 리스트 중 최대값 출력
print(max(cutters))