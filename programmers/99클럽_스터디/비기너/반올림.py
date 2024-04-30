N = input()
NList = list(N)
length = len(N)
for i in range(length - 1, -1, -1):
    eachNumber = int(NList[i])
    if i == 0:
        break
    if eachNumber >= 5:
        NList[i - 1] = str(int(NList[i - 1]) + 1)
    NList[i] = '0'
print(''.join(NList))
