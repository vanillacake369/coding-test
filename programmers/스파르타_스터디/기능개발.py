import math

def solution(progresses, speeds):
    answer = []

    # 1
    leftProgresses = [math.ceil((100 - p) / speeds[idx]) for idx, p in enumerate(progresses)]

    leftPStack = [leftProgresses[0]]
    daysToDeploy = 0
    for idx,pr in enumerate(leftProgresses):
        # 2
        if(pr <= leftPStack[-1]):
            daysToDeploy += 1
        # 3
        else:
            answer.append(daysToDeploy)
            leftPStack.append(pr)
            daysToDeploy = 1
    answer.append(daysToDeploy)
    
    # 4
    return answer