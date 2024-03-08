import heapq


def solution(scoville, K):
    mixCount = 0
    while any(K>sco for sco in scoville):
        heapq.heapify(scoville) 
        min1 = heapq.heappop(scoville)
        min2 = heapq.heappop(scoville)
        mixed = min1 + (min2 * 2)
        heapq.heappush(scoville,mixed)
        mixCount += 1
    return mixCount


scoville = [1, 2, 3, 9, 10, 12]
K = 7
result = solution(scoville, K)
print(result)
