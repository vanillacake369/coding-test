# 순열과 조합의 차이점
# 일반 순열 구하는 방법은 어떤 것이 있는가
# 중복 순열 구하는 방법은 어떤 것이 있는가
# 이번 문제는 중복 순열을 구하는 것!

# ================================================================================================


# 각 원소에 접근한다
# temp 배열에 현재 원소를 추가한다.
# temp 배열을 문자열화 하여 result 배열에 추가한다.
# temp 길이가 input_list의 길이보다 작다면 
    # 재귀호출 한다.
# temp 길이가 input_list의 길이와 동일해진다면
    # temp 배열을 비운다.
    # 재귀호출을 탈출한다.

# temp = []
# result = []
# input_list = [ 'A', 'E', 'I', 'O', 'U']

# def duplicated_perumutation(input_list):
#     global temp
#     global result
#     for input in input_list:
#         temp.append(input)
#         result_str = "".join(temp)
#         print(result_str)
#         result.append(result_str)

#         if(len(temp) < len(input_list)):
#             duplicated_perumutation(input_list)

#         if(len(temp) >= len(input_list)):
#             temp = []
#             return

# duplicated_perumutation(input_list)
# print(result)


""" 에러 발생,,,

E
EA
EAA
EAAA
EAAAA
E
EA
EAA
EAAA
EAAAA
E
EA
EAA
EAAA
EAAAA
E
EA
EAA
EAAA

RecursionError: maximum recursion depth exceeded while calling a Python object

 """