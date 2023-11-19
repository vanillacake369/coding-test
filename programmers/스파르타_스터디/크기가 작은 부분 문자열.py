t = "3141592"
p = "271"
pL = len(p)
tN = int(t)
pN = int(p)
count = 0
i = 0
while i <= len(t)-pL:
    num = int(t[i:i+pL])
    if(num <= pN):
        count += 1
    i+=1

print(count)

