# 이중 loop 로 접근하면 시간초과가 발생한다.
# 해당 코드는 아래와 같이 접근해야만 한다.
# 1. 모든 문자열의 dict() 정의, 
# 2. 각 문자열에 대해 substring, 
# 3. 해당 substring이 dict() 에 있는지 접근하는 문제이다.
def solution(phone_book):
    sortedPhoneBook = sorted(phone_book,key=lambda x : len(x))
    for i in range(0,len(sortedPhoneBook)):
        for j in range(0,len(sortedPhoneBook)):
            if(i == j):
                continue
            else:
                if(sortedPhoneBook[i].startswith(sortedPhoneBook[j])):
                    return False
    return True
    

# ph = ["1195524421","119", "97674223", ]	# false
# ph = ["123","456","789"]	# true
ph = ["12","123","1235","567","88"]	# false
result = solution(ph)
print(result)