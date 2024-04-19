from itertools import product

"""
## 아이디어
포인트는 이전 줄의 회전횟수에 따라 다음 줄의
이에 따라 완전탐색의 경우의 수를 줄일 수가 있다.
1. 따라서 첫 줄의 회전횟수의 경우를 추출하고
2. 이후의 다음 줄부터 끝까지의 회전횟수 경우를 연산한 뒤,
3. min 을 통해 총 회전횟수에 대한 최솟값을 업데이트시켜주면 된다.  

## 구현
1. 첫 번째 줄에 대해 회전하여 만들 수 있는 모든 경우의 수를 구한다.
    -> product 라이브러리를 사용하여 0~3 수에 대해 n 크기의 중복순열 생성
    -> slicing 을 통해 깊은 복사
    -> 첫 번째 줄 조작횟수의 합을 구한다.
2. 두 번째 줄부터 12시 방향이 아닌 바늘에 대해 조작한다.
    -> 조작한 바늘의 회전횟수를 총 회전횟수에 합한다.
3. 만약 회전 이후 모든 바늘에 대해 0이 아니라면 다음 경우의 수로 넘어간다 
    -> sum(arr[n-1]) == 0 을 사용
4. 총 회전횟수에 대한 min value 를 업데이트한다.

## 참고
- https://kcw0360.tistory.com/3
- https://www.youtube.com/watch?v=pl9qRAXyErs&ab_channel=%EC%86%A1%EB%AF%BC%EA%B8%B0
"""


def solution(clockHands):
    answer = 9876543210
    n = len(clockHands)

    dy = [-1, 1, 0, 0, 0]
    dx = [0, 0, -1, 1, 0]

    def rotate(a, b, t, arr):
        for k in range(5):
            y, x = a + dy[k], b + dx[k]
            if 0 <= y < n and 0 <= x < n:
                arr[y][x] = (arr[y][x] + t) % 4

    for case in product(range(4), repeat=n):  # 첫째줄 최대4번까지 회전 한다는 가정 하에 모든 경우의 수를 만든다.
        arr = [i[:] for i in clockHands]  # 깊은 복사는 deepcopy 보다 slicing 이 빠름

        for j in range(n):  # case 를 가지고 첫번째 줄만 회전 시킨다
            rotate(0, j, case[j], arr)

        result = sum(case)  # 첫번째 줄 조작 횟수의 합

        for i in range(1, n):  # 두번째 줄부터 체크
            for j in range(n):
                if arr[i - 1][j]:  # 12시 가있지 않은 시계만 조작
                    temp = 4 - arr[i - 1][j]  # 12시에 가도록 하기 위한 조작 횟수
                    rotate(i, j, temp, arr)  # 회전
                    result += temp  # 조작 횟수 누적

        if sum(arr[n - 1]):  # 마지막 라인에 12시를 향하지 않는 시계가 존재
            continue  # pass

        answer = min(answer, result)  # 시계가 모두 12시를 가리킨다면 answer을 최솟값으로 갱신

    return answer
