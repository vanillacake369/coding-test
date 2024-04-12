import math


# 배포가능날짜가 2.xx 인 경우, 실제 배포가능일자는 3일임
# 따라서 아래 선택안 중 택 1을 해야한다
# 1) math.ceil 을 사용하여 반올림을 하던지
# 2) // 처리 이후 if else 를 통해 +1 을 하던지

def solution(progresses, speeds):
    answer = []
    leftDaysToFinish = [0] * len(progresses)
    progresseStack = []
    for i in range(len(progresses)):
        leftDaysToFinish[i] = math.ceil((100 - progresses[i]) / speeds[i])
    # 7, 3, 9
    progresseStack.append(leftDaysToFinish[0])  # 7
    count = 1
    for i in range(1, len(leftDaysToFinish) + 1):
        if i == len(leftDaysToFinish):
            answer.append(count)
            break
        if leftDaysToFinish[i] <= progresseStack[-1]:
            count += 1
        else:
            progresseStack.append(leftDaysToFinish[i])
            answer.append(count)
            count = 1
    return answer


# progresses = [93, 30, 55]
# speeds = [1, 30, 5]
# progresses = [95, 90, 99, 99, 80, 99]
# speeds = [1, 1, 1, 1, 1, 1]
progresses = [1, 1, 1, 1]
speeds = [100, 50, 99, 100]
# leftDaysToFinish = [1,1,1,1] => 4일

print(solution(progresses, speeds))
