""" 
# 우선순위큐란?
- 우선순위가 가장 높은 데이터를 가장 먼저 삭제
- Min Heap, Max Heap 사용
 => 내부적으로 트리 구조를 사용하므로 삽입,삭제에는 log N이 걸림
 """

import heapq

# Iterable is an object which can be looped over or iterated over with the help of a for loop.
# Objects like lists, tuples, sets, dictionaries, strings, etc. are called iterables.


def heapsort(iterable):  # 오름차순 힙 정렬 => 최소힙
    h = []
    result = []

    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, value)

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(heapq.heappop(h))

    return result


result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])  # n에 대한 삽입,삭제 => O(NlogN)
print(result)


def heapsort(iterable):  # 내림차순 힙 정렬 :: 파이썬은 최대힙을 지원하지 않음으로, -를 통해 거꾸로 집어넣고, 거꾸로 빼는 형식으로 활용
    h = []
    result = []

    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, -value)  # 거꾸로 집어넣기

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(-heapq.heappop(h))  # 거꾸로 빼기

    return result


result2 = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])  # n에 대한 삽입,삭제 => O(NlogN)
print(result2)
