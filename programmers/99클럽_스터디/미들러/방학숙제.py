L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())
gukah = (A // C)
if A % C != 0:
    gukah += 1
suhak = (B // D)
if B % D != 0:
    suhak += 1
assgDays = max(gukah, suhak)
husikDays = L - assgDays
print(husikDays)
