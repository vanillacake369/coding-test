inputStr = list(input())
alphaList = []
numberList = []
for char in inputStr:
    if char.isupper():
        alphaList.append(char)
    else:
        numberList.append(int(char))
alphaList.sort()
sum = sum(numberList)
print("".join(alphaList) + str(sum))
