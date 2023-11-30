def solution(babbling):
    answer = 0
    # 말할 수 있는 단어들
    words = ["aya", "ye", "woo", "ma"]
    # 두번말하기
    dupWords = ["ayaaya", "yeye", "woowoo", "mama"]
    
    # 주어진 단어에 대해서
    for b in babbling:
        # 두번 말한 경우 확인
        isDup = False
        for d in dupWords:
            if(d in b):
                isDup = True
                break
        if(isDup):
            continue # 두번 말했다면 다음 단어 확인으로 넘어가기
        
        print("before : "+b)

        # 말할 수 있는 단어에 대해
        for w in words:
            # 주어진 단어 내에 말할 수 있는 단어 제거
            b = b.replace(w,"")
        # 만약 말할 수 있는 단어로 이루어져있다면 카운트
        b = b.replace(" ","")
        print("after : "+b)
        if(b == ""):
            answer += 1
    return answer

arr = ["ayaye", "ye"]

# arr = ["yeye","yeye"]	
# arr = ["ayayeye"]	
print(solution(arr))
