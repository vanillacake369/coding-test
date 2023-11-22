def solution(citations):
    citations.sort(reverse=True)
    
    # H_index를 넘는 논문이 몇 개인지 세고, H_index가 존재한다면 반환
    for i in range(len(citations)):             
        if(citations[i] < i+1):
            return i

    return len(citations) 