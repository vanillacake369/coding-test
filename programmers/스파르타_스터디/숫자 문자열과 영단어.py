def switch(digStr):
    if(digStr == "zero"):
        return '0'
    elif(digStr == "one"):
        return '1'
    elif(digStr == "two"):
        return '2'
    elif(digStr == "three"):
        return '3'
    elif(digStr == "four"):
        return '4'
    elif(digStr == "five"):
        return '5'
    elif(digStr == "six"):
        return '6'
    elif(digStr == "seven"):
        return '7'
    elif(digStr == "eight"):
        return '8'
    elif(digStr == "nine"):
        return '9'
    return None

def solution(s):
    result = []
    digStr = ""
    for ch in s:
        if(ch.isdigit()):
            result.append(str(ch))
            continue
        digStr += ch
        if(len(digStr) >= 3):
            if(switch(digStr) != None):
                result.append(switch(digStr))
                digStr = ""
    return int("".join(result))

s = "onetwo123"
print(solution(s))