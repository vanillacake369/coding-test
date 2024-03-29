""" 
특정 노드 -> 다른 모든 노드

- 음의 간선이 없을 때 정상동작
- 그리디 알고리즘으로 분류
    - Ex) 길 찾기 같은 문제에서 매 상황 별 가장 비용이 적은 노드 선택
 """

""" 
1. 출발 노드 설정
2. 최단 거리 테이블 초기화 :: 
<3~4번을 반복>
3. 방분하지 않은 노드 중 최단 거리 짧은 노드 선택 
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단거리 테이블 갱신
 
* 3번에서의 "최단거리"라는 특징이 그리디 알고리즘으로 분류하게끔 함
 """



