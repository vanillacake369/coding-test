import sys
input = sys.stdin.readline()

words = input.split(" ")
w = []

for word in words:
    str = ""
    for idx in range(0,len(word)):
        if(i % 2 == 0):
            str += word[i].upper()
        else :
            str += word[i].lower()
    w.append(str)

answer = " ".join(w)
print(answer)
    
    