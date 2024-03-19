def solution(s):
    sliceStrs = []
    for i in range(1, len(s)+1):
        count = 1
        sliceStr = s[:i]
        shortenStr = ""
        for j in range(i,len(s)+i,i):
            if sliceStr == s[j:j+i]:
                count += 1
            else:
                if count == 1:
                    shortenStr = shortenStr + sliceStr
                else:
                    shortenStr = shortenStr + str(count) + sliceStr
                sliceStr = s[j:j+i]
                count = 1
        sliceStrs.append(shortenStr)
    sliceStrs = sorted(sliceStrs, key = lambda x:len(x))
    return len(sliceStrs[0])

# s = "aabb"
# s = "aabbaccc"
s = "ababcdcdababcdcd"
print(solution(s))
