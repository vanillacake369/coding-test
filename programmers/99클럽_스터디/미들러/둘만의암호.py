def solution(s, skip, index):
    answer = ''
    alpha = 'abcdefghijklmnopqrstuvwxyz'
    for sk in skip:
        alpha = alpha.replace(sk, '')
    for c in s:
        change = alpha.find(c) + index
        while change >= len(alpha):
            change -= len(alpha)
        answer += alpha[change]
    return answer
