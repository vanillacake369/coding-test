# https://velog.io/@mjieun/Python-%EC%88%9C%EC%97%B4%EC%A1%B0%ED%95%A9%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with-%EC%9E%AC%EA%B7%80#-%EC%A4%91%EB%B3%B5-%EC%88%9C%EC%97%B4
# 입력리스트에서 1~N개의 원소 중복순열 생성

def dfs(result,input_list,pick,level,dynamic_pick_count):
		# pick_count 모두 뽑았으면 출력하고 리턴
    if level == dynamic_pick_count:
        result.append(''.join(pick))
        return
    for i in range(len(input_list)):
        pick[level] = input_list[i]  # 카드 뽑고
        dfs(result,input_list,pick,level+1,dynamic_pick_count)  # 다음 카드 뽑으러 가기
        pick[level] = 0  # 리턴 이후 뽑은 카드 초기화


def solution(word):
    answer = 0
    pick_count = 5
    input_list = [ 'A', 'E', 'I', 'O', 'U']
    result = []

    for i in range(1,pick_count+1):
        pick = [0] * i # 1 [0], 2 [0,0] ,3 [0,0,0]
        dfs(result,input_list,pick,0,i)

    result.sort()
    answer = result.index(word) + 1
    return answer


print(solution("AAAAE"))
print(solution("AAAE"))
print(solution("I"))
print(solution("EIO"))