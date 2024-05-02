# 정답 참조
# [참조링크](https://programming4myself.tistory.com/89)

"""
> 조이스틱 위 아래 판별
- 위로 움직여서 찾는 경우와 아래로 움직여서 찾는 경우를 비교해줘서 작은 값을 더해주기

> 조이스틱 오른쪽/왼쪽 판별
- 중간에서 문자열을 자른 다음,
    - 그냥 쭉 가는 경우
    - 왼쪽으로 갔다가 오른쪽 가는 경우
    - 오른쪽으로 갔다가 왼쪽으로 가는 경우
    - 완전탐색으로 비교
EG)
BBBBAAAA : 오른쪽으로 3칸만 가주면 된다.
BAAAABBB : 왼쪽으로 3칸을 가주어야 한다.
BBAAAABB : 오른쪽으로 한칸 갔다가 되돌아오고, 다시 왼쪽으로 2칸 가주어야 한다.
BBBBABBB : 그냥 왼쪽 또는 오른쪽으로 쭉 가는게 빠르다.
"""


def solution(name):
    answer = 0
    for char in name:
        char_diff = ord(char) - ord('A')
        answer += min(char_diff, 26 - char_diff)

    move = len(name) - 1
    for i in range(1, len(name)):
        right = len(name[1:i].rstrip('A'))
        left = len(name[i:].lstrip('A'))
        move = min(move, 2 * right + left, 2 * left + right)

    answer += move

    return answer
