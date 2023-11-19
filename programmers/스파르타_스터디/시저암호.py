def solution(s, n):
    result = ""
    s = list(s)
    for c in s:
        # 대문자 / 소문자 케이스
        if c.isupper():
            # A + (c와A사이간격 % 알파벳개수)
            c = chr((ord(c) - ord('A') + n) % 26 + ord('A'))
        elif c.islower():
            # a + (c와A사이간격 % 알파벳개수)
            c = chr((ord(c) - ord('a') + n) % 26 + ord('a'))
        result += c
    return result
    