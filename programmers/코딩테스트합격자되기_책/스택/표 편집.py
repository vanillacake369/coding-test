def solution(n, k, cmd):
    answer = ''
    dataCount = n
    removeHistoryStack = []
    # 아예 이런 식으로 링크드 리스트를 dict 로 처리할 수도 있구나 ㅇㅅㅇ
    # -> 책에서는 up,down 으로 쪼개서 저장
    # 다시 한 번 풀어보자ㅏㅏ
    table = {i: [i - 1, i + 1] for i in range(n)}
    return answer


print(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]))
# "OOOOXOOO"
print(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]))
# "OOXOXOOO"
