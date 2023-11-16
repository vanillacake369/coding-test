n = 3
lost = [3]
reserve = [1]
# lost = [2,4]
# reserve = [3]
# lost = [2,4]
# reserve = [1,3,5]

lost_count = len(lost)
for i in range(0,len(lost)):
    for j in range(0,len(reserve)):
        if(lost[i] == reserve[j]-1 or lost[i] == reserve[j]+1 ):
            lost_count -= 1
            reserve.remove(reserve[j])
            break

print(n - lost_count)
