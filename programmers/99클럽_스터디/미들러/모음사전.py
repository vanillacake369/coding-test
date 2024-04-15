# 조합 라이브러리인  product 라이브러리를 사용
# 평균 3ms


#
#
# def solution(word):
#     wordSet = set()
#     wordList = ["", "A", "E", "I", "O", "U"]
#     wordProduct = product(wordList, repeat=5)
#     for w in wordProduct:
#         wordSet.add("".join(w))
#     sortedWordProducts = sorted(list(wordSet))
#     for idx, eachWord in enumerate(sortedWordProducts):
#         if word == eachWord:
#             return idx
def solution(word):
    vowels = ['A', 'E', 'I', 'O', 'U']
    words = []
    count = [0]  # dfs 함수가 실행된 횟수를 저장하는 변수

    def dfs(cur_word):
        words.append(cur_word)
        count[0] += 1  # dfs 함수가 실행될 때마다 count 증가

        # 길이가 5 이하인 경우에만 탐색을 진행
        # -> 이 말인 즉슨, 길이가 5에 도달하면 dfs 탈출하여 이전 재귀함수로 돌아감
        #    트리 구조를 그려보면 알 수 있음
        if len(cur_word) < 5:
            for vowel in vowels:
                dfs(cur_word + vowel)

    # 깊이 우선 탐색 실행
    dfs("")

    # 사전에서 몇 번째 단어인지 계산하여 반환
    print("DFS 함수 실행 횟수:", count[0])  # 언제나 DFS 함수 실행 횟수: 3906
    return words.index(word)


print(solution("I"))
