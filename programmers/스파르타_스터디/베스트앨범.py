# 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 ,,,
# => "두 개까지 모은다" 의 기준은 어디있음??

"""
1. [장르 : 전체 횟수]
2. 장르 => [고유번호 : 재생횟수]
3. "재생횟수" 기준 "내림차순"으로 고유번호 정렬
4. 각 장르의 고유번호 갯수 중 최소값 구하기
5. 최소값에 따른 고유번호 poll, add
 """

def solution(genres, plays):
    answer = []

    #1
    allPlays = dict()
    for g,p in zip(genres,plays):
        allPlays[g]=allPlays.get(g,0) + p
    sortedAllPlays = dict(sorted(allPlays.items(),key=lambda x:x[1],reverse=True))

    #2 
    playPerGenres = dict()
    for idx,g in enumerate(genres):
        play = {idx:plays[idx]}
        if not (g in playPerGenres):
            playPerGenres[g] = []
        playPerGenres[g].append(play)

    #3
    sorted_playPerGenres = {genre: sorted(genre_data, key=lambda x: list(x.values())[0], reverse=True) for genre, genre_data in playPerGenres.items()}
    
    #4
    for sap in sortedAllPlays :
        for i in range(0,len(sorted_playPerGenres)):
            answer.append(list(sorted_playPerGenres[sap][i].keys())[0])

    return answer

gen = ["classic", "pop", "classic", "classic", "pop"]	
pl = [500, 600, 150, 800, 2500]	
result = solution(gen,pl)
print(result)