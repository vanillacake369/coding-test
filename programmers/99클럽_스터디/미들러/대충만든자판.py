def solution(keymap, targets):
    answer = []
    keyboard = dict()
    targetCounts = [0] * len(targets)
    for key in keymap:
        for idx, eachKey in enumerate(key):
            if eachKey in keyboard:
                keyboard[eachKey] = min(idx + 1, keyboard.get(eachKey))
            else:
                keyboard[eachKey] = idx + 1
    for idx, eachTarget in enumerate(targets):
        for eachTargetKey in eachTarget:
            if eachTargetKey in keyboard:
                targetCounts[idx] += keyboard.get(eachTargetKey)
            else:
                targetCounts[idx] = -1
                break
    return targetCounts


keymap = ["ABACD", "BCEFD"]
targets = ["ABCD", "AABB"]
print(solution(keymap, targets))
