N = int(input())
fileSizes = list(map(int, input().split()))
clusterSize = int(input())

for eachFile in fileSizes:
    if eachFile > clusterSize:
        N += (eachFile - 1) // clusterSize
    elif eachFile == 0:
        N -= 1

print(clusterSize * N)
