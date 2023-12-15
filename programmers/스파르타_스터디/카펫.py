def solution(brown,yellow):
    answer = []
    wy = 1
    hb = 1
    wb = 1
    for i in range(1,int(yellow ** (1/2)) + 1):
        if yellow % i == 0:
            wy = yellow // i
            if ( 2*i + 2*wy + 4 == brown):
                hb = i+2
                wb = wy+2
                break
    answer.append(wb)
    answer.append(hb)
    return answer