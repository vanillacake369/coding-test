# 정답은 정답인데,
# 수학적인 공식을 사용하지 않아 1번 케이스에서 시간초과가 뜬다
# 다른 풀이를 찾아봤는데 조합으로 접근하면 무조건 시간초과가 뜬다,,,^^

from itertools import combinations
def solution(clothes):
    clothesHashMap = dict()
    for c in clothes:
        clothesHashMap[c[1]] = clothesHashMap.get(c[1], 0) + 1


    clothesType = list(clothesHashMap.values())

    total_sum = 0

    # 각 의상 종류별로 선택한 옷의 개수를 이용하여 조합 생성
    for i in range(1, len(clothesType) + 1):
        for comb in combinations(clothesType, i):
            product = 1
            # 조합에 포함된 각 의상 종류별로 선택한 옷의 개수를 곱함
            for num in comb:
                product *= num
            total_sum += product
    
    return total_sum

# clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
# clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	
clothes = [["a", "A"], ["b", "B"], ["c", "C"]]
answer = solution(clothes)
print(answer)