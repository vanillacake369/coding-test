"""
1. {장르 : 전체횟수} 구한 뒤, "전체횟수" 기준 "내림차순" 정렬
2. {장르 : [ {고유번호:재생횟수},{고유번호:재생횟수} ,,, ]}
3. "재생횟수" 기준 "내림차순"으로 고유번호 정렬
4. 전체횟수 내림차순으로 순회, 
   모든 장르 중 고유번호 최소갯수만큼 고유번호 추출,
   result 리스트에 append
"""

def solution(genres, plays):
    answer = []

    #1 {장르 : 전체횟수} 
    total_plays_per_genre = dict()
    for g,p in zip(genres,plays):
        total_plays_per_genre[g]=total_plays_per_genre.get(g,0) + p

    #2  {장르 : [ {고유번호:재생횟수},{고유번호:재생횟수} ,,, ]}
    playPerGenres = dict()
    for idx,g in enumerate(genres):
        play = {idx:plays[idx]}
        if not (g in playPerGenres):
            playPerGenres[g] = []
        playPerGenres[g].append(play)

    #3 "재생횟수" 기준 "내림차순"으로 playPerGenres 정렬
    sorted_playPerGenres = {genre: sorted(genre_data, key=lambda x: list(x.values())[0], reverse=True) for genre, genre_data in playPerGenres.items()}
    print(sorted_playPerGenres)
    
    #4 "총 재생횟수" 기준 "내림차순" 으로 total_plays_per_genre 정렬
    sorted_genres = sorted(total_plays_per_genre.keys(), key=lambda x: -total_plays_per_genre[x])

    #5 장르 별 최대 2 노래 추가
    for genre in sorted_genres:
        count = 0
        print( sorted_playPerGenres[genre])
        for pg in sorted_playPerGenres[genre]:
            for idx,play in pg.items():
                answer.append(idx)
            count+=1
            if count >= 2:
                break
                
    return answer


gen = ["classic", "pop", "classic", "classic", "pop"]	
pl = [500, 600, 150, 800, 2500]	
result = solution(gen,pl)
result1 = solution1(gen,pl)
print(result)
print(result1)


# def solution(genres, plays):
#     answer = []

#     #1 {장르 : 전체횟수} 구한 뒤, "전체횟수" 기준 "내림차순" 정렬
#     total_plays_per_genre = dict()
#     for g,p in zip(genres,plays):
#         total_plays_per_genre[g]=total_plays_per_genre.get(g,0) + p
#     sortedAllPlays = dict(sorted(total_plays_per_genre.items(),key=lambda x:x[1],reverse=True))

#     #2  {장르 : [ {고유번호:재생횟수},{고유번호:재생횟수} ,,, ]}
#     playPerGenres = dict()
#     for idx,g in enumerate(genres):
#         play = {idx:plays[idx]}
#         if not (g in playPerGenres):
#             playPerGenres[g] = []
#         playPerGenres[g].append(play)

#     #3 "재생횟수" 기준 "내림차순"으로 고유번호 정렬
#     sorted_playPerGenres = {genre: sorted(genre_data, key=lambda x: list(x.values())[0], reverse=True) for genre, genre_data in playPerGenres.items()}
    
#     #4 전체횟수 내림차순으로 순회, 모든 장르 중 고유번호 최소갯수만큼 고유번호 추출, result 리스트에 append
#     minPlayPerGenres = 100000000000
#     for s in sorted_playPerGenres:
#         minPlayPerGenres = min(minPlayPerGenres,len(sorted_playPerGenres[s]))
#     for sap in sortedAllPlays:
#         for i in range(0,minPlayPerGenres):
#             answer.append(list(sorted_playPerGenres[sap][i].keys())[0])

#     return answer