def solution(word):
    answer = 0
    for i, n in enumerate(word):
        answer += (5 ** (5 - i) - 1) / (5 - 1) * "AEIOU".index(n) + 1
    return answer
# 출처: https://alreadyusedadress.tistory.com/297 [ :티스토리]