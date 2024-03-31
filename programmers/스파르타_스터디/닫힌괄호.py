def solution(s):
    stack = []
    for c in s:
        if c == "(":
            stack.append(c)
        elif c == ")":  # -> isEmpty(list)
            if not stack:
                return False
            else:
                stack.pop()
    if stack:  # -> isEmpty(list)
        return False
    else:
        return False
