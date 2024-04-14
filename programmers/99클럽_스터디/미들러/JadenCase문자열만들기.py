def solution1(s):
    answer = []
    strs = s.split(" ")
    for chs in strs:
        if len(chs) != 0:
            chs = chs[0].upper() + chs[1:].lower()
        answer.append(chs)
    return " ".join(answer)
