# num, count = map(int, input().split())
num, count = 4, 4


# 아래와 같이 풀 수 있겠지만,,,
# 어떻게 하면 백트래킹으로 접근할까??
# from itertools import product
# nList = [i for i in range(1, num + 1)]
# print(list(product(nList, repeat=count)))

# dfs 로 level depth 가 count 가 되면 탈출 이후 순열을 answer list 에 append
def dfs():
    # level depth 가 count 가 되면 탈출
    if len(temp) == count:
        answer.append(' '.join(map(str, temp)))
        return
    # 1 ~ num 까지
    for i in range(1, num + 1):
        # 방문표시된 노드라면 다음 노드 탐색
        if visited[i]:
            continue
        # 요소 추가 & 방문표시 추가
        visited[i] = True
        temp.append(i)
        dfs()
        # 함수 종료 이후에 요소를 제거 & 방문표시 제거
        temp.pop()
        visited[i] = False


visited = [False for _ in range(num + 1)]
answer = []
temp = []
dfs()
for eachAnswer in answer:
    print(eachAnswer)
