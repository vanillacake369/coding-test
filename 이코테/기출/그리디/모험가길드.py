N = int(input())
pl = list(map(int, input().split()))

pl.sort()

result = 0    
count = 0     

for p in pl:
    count += 1 
    if count >= p: 
        result += 1    
        count = 0      
        
print(result)