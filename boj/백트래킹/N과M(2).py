N, M = map(int, input().split())

# dfs 로 접근

temp = []


def dfs(init, m):
    #  N 에 다다르면 다시 돌아오기
    if m == M:
        print(' '.join(map(str, temp)))
        return
    for i in range(init, N + 1):
        if not (i in temp):
            temp.append(i)
            dfs(i + 1, len(temp))  # i + 1 삽입하도록 하여 i,i+1,i+2 순의 순열만 나오게끔 하기
            temp.pop()


dfs(1, 0)
