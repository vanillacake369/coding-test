def solution(cards1, cards2, goal):
    answer = ''
    isPoss = True
    i1 = 0
    i2 = 0
    for i in range(0,len(goal)):
        g = goal[i]
        if(i1 != len(cards1) and g == cards1[i1]):
            i1 += 1
            continue
        if(i2 != len(cards2) and g == cards2[i2]):
            i2 += 1
            continue
        isPoss = False
        break
    answer = "Yes" if isPoss == True else "No"
    return answer

cards1 = ["i", "water", "drink"]
cards2 = ["want", "to"]
goal = ["i", "want", "to", "drink", "water"]	
# cards1 = ["i", "drink", "water"]	
# cards2 = ["want", "to"]	
# goal = ["i", "want", "to", "drink", "water"]	
print(solution(cards1,cards2,goal))