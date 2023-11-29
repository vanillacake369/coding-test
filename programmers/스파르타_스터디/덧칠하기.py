def solution(n, m, section):
    start = section[0]
    end =start + m-1
    answer = 1
    for i in section:
        if i >= start and i <= end:
            continue
        else:
            start = i
            end = i + m-1
            ans += 1
    return answer