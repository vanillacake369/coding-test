number = list(map(int,input()))
# number = list(map(int,'02984'))
# number = list(map(int,'567'))
result = number[0]
for idx,n in enumerate(number):
    if(idx == 0):
        continue
    if(n<=1 or result <=1):
        result += n
    else:
        result *= n
print(result)