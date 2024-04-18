def solution(n, a, b):
    count = 0
    """
    아무리 봐도 이진탐색인데,,,
    """
    while a != b:
        a = (a + 1) // 2
        b = (b + 1) // 2
        count += 1
    return count
