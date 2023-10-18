import sys
sys.setrecursionlimit(10000) # 재귀 깊이 설정;

mem = [0] * 30001

x = int(sys.stdin.readline())

for i in range(x+1):
    mem[i] = mem[i-1] + 1
    if(i%2 == 0):
        mem[i] = min(mem[i],mem[i//2] + 1) # / : float <-> / : int
    if(i%3 == 0):
        mem[i] = min(mem[i],mem[i//3] + 1) # / : float <-> / : int
    if(i%5 == 0):
        mem[i] = min(mem[i],mem[i//5] + 1) # / : float <-> / : int

print(mem[x])