def solution(want, number, discount):
    answer = 0
    want_dic = dict()
    for i in range(len(want)):
        want_dic[want[i]] = number[i]
    

    # 이렇게 허무하게 loop로 풀게 되다니,,,
    # 다른 방법이 없는지 찾지 않고 
    # 이렇게 풀리나? 하면서 구현하면 
    # 끝나는 문제였다,,,
    start = 0
    end = len(discount) - 9
    for i in range(start,end):
        want_dic_temp = want_dic.copy()
        for j in range(i,i+10):
            if(discount[j] in want_dic_temp):
                want_dic_temp[discount[j]] -= 1
        isPossible = True
        for v in want_dic_temp.values():
            if(v > 0):
                isPossible = False
        if(isPossible):
            answer += 1
    return answer

want = ["banana", "apple", "rice", "pork", "pot"]
number = [3, 2, 2, 2, 1]
discount = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]

# want = ["apple"]	
# number = [10]
# discount = ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]	
print(solution(want,number,discount))