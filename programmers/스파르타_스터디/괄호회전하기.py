def solution(s):
    count = 0
    openBracket = ["(", "{", "["]
    # 회전할 수 & 각 인덱스에 접근하며
    for i in range(len(s)):
        stack = []
        isEmpty = False
        for j in range(len(s)):
            # 회전한 괄호
            c = s[(i + j) % len(s)]
            # 만약 열린 괄호라면 스택에 추가
            if c in openBracket:
                stack.append(c)
            # 닫힌 괄호가 아예 없다면 탈출
            else:
                if not stack:
                    isEmpty = True
                    break
                # 괄호들에 대해 일치성 판별
                if c == ")" and stack[-1] == "(":
                    stack.pop()
                elif c == "}" and stack[-1] == "{":
                    stack.pop()
                elif c == "]" and stack[-1] == "[":
                    stack.pop()
                else:
                    break
        if not isEmpty:
            if not stack:
                count += 1
        # 만약 isEmpty 를 안 쓰고 for loop 탈출 이후 체킹을 하고 싶다면
        # for - else 를 사용할 수 있다!!
        # else:
        #     if not stack:
        #         count += 1
    return count


print(solution(s="[](){}"))
# result = 3
print(solution(s="}]()[{"))
# result = 2
print(solution(s="[)(]"))
# result = 0
print(solution(s="}}}"))
# result = 0
