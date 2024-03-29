def solution(N, stages):
    # N+1 사용자, 즉 N번째 클리어한 사용자를 저장하려면 N+2 만큼 필요
    challenger = [0] * (N + 2)
    # 스테이지 별 클리어한 사람들 계산
    for stage in stages:
        challenger[stage] += 1
    # 스테이지 별 실패한 사용자 수 계산
    fails = dict()
    # 각 스테이지 별 인원 수. 초기에는 전체 인원수
    total = len(stages)
    # 각 스테이지 순회하며 실패율 계산
    for i in range(1, N + 1):
        # 도전한 사람이 없는 경우 실패율 0
        if challenger[i] == 0:
            fails[i] = 0
        # 실패율을 구하고 fails 에 저장, 다음 스테이지 인원수 계산
        else:
            fails[i] = challenger[i] / total
            total -= challenger[i]
    # 실패율(value) 에 따라 내림차순 정렬된 실패한 사용자(key) 를 반환
    return sorted(fails, key=lambda x: fails[x], reverse=True)
    """ python 포인뜨!
    1. dict 에 대해 value 에 따라 정렬된 dict 를 반환하고 싶다.
        -> sorted 를 통해 정렬된 dict 를 list 로 추출, 다시 dict 로 변환
        * items() 사용
        * key = lambda x:x[1] 을 통해 value 를 지칭
    footballers_goals = {'Eusebio': 120, 'Cruyff': 104, 'Pele': 150, 'Ronaldo': 132, 'Messi': 125}
    sorted_footballers_by_goals = sorted(footballers_goals.items(), key=lambda x:x[1])
    sorted_footballers_by_goals = dict(sorted_footballers_by_goals)
    ## {'Cruyff': 104, 'Eusebio': 120, 'Messi': 125, 'Ronaldo': 132, 'Pele': 150}

    2. dict 에 대해 value 에 따라 정렬된 key 값들을 반환하고 싶다.
        -> sorted 를 통해 정렬된 dict 에 대한 key 값을 추출
        * 원본dict 를 넣기
        * key = lambda x:원본dict[x] 를 사용하여 value 를 지칭
    footballers_goals = {'Eusebio': 120, 'Cruyff': 104, 'Pele': 150, 'Ronaldo': 132, 'Messi': 125}
    sorted_footballers_by_goals_value = sorted(footballers_goals, key=lambda x:footballers_goals[x])
    ## ['Cruyff', 'Eusebio', 'Messi', 'Ronaldo', 'Pele']
     """


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
result = solution(N, stages)
print(result)