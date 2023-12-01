def solution(keymap, targets):
    answer = []
    keyDict = {}
    for key in keymap:
        for idx,k in enumerate(key):
            if(keyDict.get(k) == None) or (keyDict.get(k) > idx):
                keyDict.update({k:idx+1})
    for t in targets:
        sum = 0
        for idx,t in enumerate(t):
            if(keyDict.get(t) == None):
                sum = -1
                break
            sum += keyDict.get(t)
        answer.append(sum)
    return answer

keymap = ["AGZ", "BSSS"]	
targets = ["ASA","BGZ"]	
# keymap = ["AA"]	
# targets = ["B"]	
# keymap = ["ABACD", "BCEFD"]	
# targets = ["ABCD","AABB"]	
result = solution(keymap,targets)
print(result)