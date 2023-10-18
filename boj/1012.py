import sys
sys.setrecursionlimit(10000) # 재귀 깊이 설정;

def dfs(x,y):
    if x <= -1 or x >= n or y <= -1 or y >= m :
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False

t = int(sys.stdin.readline())

# Each Test Case
for i in range(t) :
    m,n,k = map(int, sys.stdin.readline().split())
    graph = [ [ 0 ] * m for _ in range(n)]
    # Insert 배추 위치
    for j in range(k):
        x,y = map(int,sys.stdin.readline().split())
        graph[y][x] = 1
    # DFS for every node
    insect = 0
    for j in range(n):
        for l in range(m):
            if(dfs(j,l) == True):
                insect +=1  
    print(insect)