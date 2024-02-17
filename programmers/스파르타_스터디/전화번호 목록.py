# ------------------------------------------
# def solution(phone_book):
#     ph = sorted(phone_book,key=lambda phone_book: len(phone_book)) # O(N log N)
#     max_len = len(ph[-1])
#     min_len = len(ph[0])
#     for l in (min_len,max_len+1):   # O(N)
#         hashMap = dict()
#         for p in ph:
#             pOfLength = p[0:l]
#             if(hashMap.get(pOfLength) == None):
#                 hashMap.setdefault(pOfLength,1)
#             else:
#                 return False
#     return True
#
# 0~m 까지의 문자열 비교하므로 부분적인 문자열이 포함되어있기만 하는지 확인함
# 즉, 문자열 간 비교를 해야하는데 부분적 비교를 하므로 오류가 발생함
# 따라서 위 코드는 아래와 같은 케이스가 통과되지 않음
# ph =  ["123", "1197", "557713", "11987543"] # True



# ------------------------------------------
# def solution(phone_book):
    
#     hashMap = {}
#     for nums in phone_book: # O(N)
#         hashMap[hash(nums)] = nums

#     for nums in phone_book:
#         arr = ""
#         for num in nums:
#             arr += num

#             if hash(arr) in hashMap and arr != nums:
#                 return False
    
#     return True
# 
# 위 풀이가 바로 정답 풀이 ~!


#----------------------------------------
# Solution 3: sort( )와 startswith( ) 사용하기
def solution(phoneBook):
    phoneBook.sort()

    for p1, p2 in zip(phoneBook, phoneBook[1:]):
        if p2.startswith(p1):
            return False
    return True
# sort를 해준후 zip으로 본인(p1)과 본인의 다음값(p2)을 묶음 처리해준다.

# for문을 돌면서 startwith 함수를 이용해 p2가 p1으로 시작하는지 검사한다.

 

# zip( )
# zip 함수는 여러 개의 iterable자료형의 크기가 동일할 때 사용한다. ( 크기가 다를경우 순서대로 생성후 None값 삽입)

# iterable 자료형의 각각의 요소를 나눈 후 순서대로 묶어서 요소 개수만큼 새로운 iterable 자료형을 생성

# -for문과 사용을 많이 한다
# ex)    for x, y in zip(range(10), range(10)) :