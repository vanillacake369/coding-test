import heapq


def solution(scoville, K):
    mixCount = 0
    heapq.heapify(scoville)
    while K > min(scoville) :
        min1 = heapq.heappop(scoville)
        min2 = heapq.heappop(scoville)
        mixed = min1 + (min2 * 2)
        if len(scoville) == 0:
            if mixed < K:
                return -1
        heapq.heappush(scoville, mixed)
        mixCount += 1
    return mixCount


scoville = [1, 2, 3, 9, 10, 12]
K = 7
result = solution(scoville, K)
print(result)


# heap.heappush()/heappop() => O(logN)
# heap.heapify() => O(NlogN)
# any() => O(N)
