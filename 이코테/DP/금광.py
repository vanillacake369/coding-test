t = int(input())

def getMaxGold():
    n,m = map(int,input().split())
    arr = [[0 for j in range(m)] for i in range(n)]
    for i in range(n):
        for j in range(m):
            arr[i][j] = int(input())
    
    print(arr)

for i in range(0,t):
    print(getMaxGold())
