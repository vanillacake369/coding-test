# 바보 같이 동일한 박스의 개수를 세어버리고 말았다,,,
# 그냥 박스에 대한 가격값을 계속 합산해주면 되는데,,,
def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    for i in range(0, len(score), m):
        box = score[i:i + m]
        if len(box) == m:
            answer += box[m - 1] * m
    return answer


print(solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]))
