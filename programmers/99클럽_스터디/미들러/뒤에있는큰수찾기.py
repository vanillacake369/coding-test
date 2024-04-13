# stack 을 쓰긴쓰는데, partial loop 로써 사용되는 거라,,, 짱구를 좀 굴려야 하는 문제,,,
def solution(numbers):
    n = len(numbers)
    answer = [-1 for _ in range(0, n)]
    stack = []
    for i in range(n - 1, -1, -1):
        # numbers[i] 에 대해 스택의 top 이 같거나 작다면 스택에서 값 제거
        # => 스택에는 numbers[i] 보다 큰 값이 남게됨
        while stack and stack[-1] <= numbers[i]:
            stack.pop()
        # stack 에 값이 있다면 top 을, 없다면 numbers[i] 가 가장 큰 값이므로 -1
        answer[i] = stack[-1] if stack else -1
        # 다음 수를 위해 현재값을 스택에 추가
        stack.append(numbers[i])
    return answer
