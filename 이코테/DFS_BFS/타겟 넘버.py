def solution(numbers, target):
    # 역정렬
    numbers.sort(reverse = True)
    # sum == target인 인덱스 찾고, 해당 인덱스 제외한 모든 수 추출
    sum = 0
    leftNum = []
    for i in range(0,len(numbers)):
        sum += numbers[i]
        if(sum == target):
            leftNum = numbers[i+1:len(numbers)]
    print(leftNum)
    ans = []
    cnt = dfs(leftNum,ans)
    return cnt

# 남은 수를 가지고 0을 만들 수 있는 모든 경우의 수 탐색
def dfs(leftNum,ans):
        count = 0

        if(sum(ans) == 0):
            return 1
        for i in range(0,len(leftNum)):
            ans.append(abs(leftNum(i)))
    # 모든 경우의 수 반환



# numbers = [1, 1, 1, 1, 1]	
# target = 3
numbers = [4, 1, 2, 1]	
target = 4
result = solution(numbers,target)
print(result)