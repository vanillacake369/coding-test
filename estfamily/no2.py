"""
Top : Pair, Straight, Straight Flush 가 아닌 패
Pair  :3 장 중 2장이 같은 패
Straight : 3장 연속, Straight Flush 가 아닌 패
Straight Flush : 3 장의 카드 숫자 연속, 색이 모두 같은 패
"""
"""
각 플레이어 패 : 자신 손 1 + 공유 카드 2 (총 3)
자신의 패 > 상대방 패 : 승리
자신의 패 == 상대방 패 : 자신 손 서로 비교
    - 숫자가 높으면 승리
    - 숫자가 같으면 빨간색 승리 
"""

"""
cards[0] 은 내 카드
cards[1] 은 상대 카드
cards[2] 은 첫 번째 공유 카드
상대방 족보를 이길 수 있는 두 번째 공유 카드 리스트를 추출, 없다면 "lose" 를 담아 반환
"""


# Pair 가 나오는 경우 중 상대보다 높은 패
# Straight 가 나오는 경우 중 상대보다 높은 패
# Straight Flush 가 나오는 경우 중 상대보다 높은 패
def isWinningPair(you, rival, firstShared, secondShared):
    # 각 플레이어의 카드와 공유 카드를 합칩니다.
    all_cards_you = [you, firstShared, secondShared]
    all_cards_rival = [rival, firstShared, secondShared]

    # 카드 숫자만 추출하여 리스트로 만듭니다.
    numbers_you = [card[0] for card in all_cards_you]
    numbers_rival = [card[0] for card in all_cards_rival]

    # 각 플레이어의 카드에서 같은 숫자가 2장 있는지 확인합니다.
    isYouPair = False
    isRivalPair = False
    for num in numbers_you:
        if numbers_you.count(num) == 2:
            isYouPair = True
    for num in numbers_rival:
        if numbers_rival.count(num) == 2:
            isRivalPair = True
    if isYouPair == isRivalPair == True:
        if you[0] > rival[0]:
            isYouPair = True
    return isYouPair


def isWinningStraight(you, rival, firstShared, secondShared):
    # 각 플레이어의 카드와 공유 카드를 합칩니다.
    all_cards_you = [you, firstShared, secondShared]
    all_cards_rival = [rival, firstShared, secondShared]

    # 카드 숫자만 추출하여 리스트로 만듭니다.
    numbers_you = sorted([card[0] for card in all_cards_you])
    numbers_rival = sorted([card[0] for card in all_cards_rival])

    # 카드 숫자 리스트를 문자열로 변환합니다.
    num_str_you = ''.join(map(str, numbers_you))
    num_str_rival = ''.join(map(str, numbers_rival))

    # 연속된 숫자가 있는지 확인합니다.
    if '123' in num_str_you or '234' in num_str_you or '345' in num_str_you or '456' in num_str_you or '567' in num_str_you or '678' in num_str_you or '789' in num_str_you:
        return True
    if '123' in num_str_rival or '234' in num_str_rival or '345' in num_str_rival or '456' in num_str_rival or '567' in num_str_rival or '678' in num_str_rival or '789' in num_str_rival:
        return False
    return False


def isWinningStraightFlush(you, rival, firstShared, secondShared):
    # 각 플레이어의 카드와 공유 카드를 합칩니다.
    all_cards_you = [you, firstShared, secondShared]
    all_cards_rival = [rival, firstShared, secondShared]

    # 색이 모두 같은 카드를 추출합니다.
    same_color_cards_you = [card for card in all_cards_you if card[1] == secondShared[1]]
    same_color_cards_rival = [card for card in all_cards_rival if card[1] == secondShared[1]]

    # 카드 숫자만 추출하여 리스트로 만듭니다.
    numbers_you = sorted([card[0] for card in same_color_cards_you])
    numbers_rival = sorted([card[0] for card in same_color_cards_rival])

    # 카드 숫자 리스트를 문자열로 변환합니다.
    num_str_you = ''.join(map(str, numbers_you))
    num_str_rival = ''.join(map(str, numbers_rival))

    # 모두 같은 색깔로 연속된 숫자가 있는지 확인합니다.
    if '123' in num_str_you or '234' in num_str_you or '345' in num_str_you or '456' in num_str_you or '567' in num_str_you or '678' in num_str_you or '789' in num_str_you:
        return True
    if '123' in num_str_rival or '234' in num_str_rival or '345' in num_str_rival or '456' in num_str_rival or '567' in num_str_rival or '678' in num_str_rival or '789' in num_str_rival:
        return False
    return False


def solution(cards):
    you = cards[0]
    rival = cards[1]
    firstShared = cards[2]
    secondSharedList = []
    answer = []

    for num in range(1, 10):
        for color in ["r", "b"]:
            secondShared = str(num) + str(color)
            if secondShared in cards:
                continue
            secondSharedList.append(secondShared)

    for secondShared in secondSharedList:
        if isWinningPair(you, rival, firstShared, secondShared):
            answer.append(secondShared)
        if isWinningStraight(you, rival, firstShared, secondShared):
            answer.append(secondShared)
        if isWinningStraightFlush(you, rival, firstShared, secondShared):
            answer.append(secondShared)

    answer = sorted(list(set(answer)))

    if len(answer) == 0:
        return ["lose"]
    return answer


# cards = ["7b", "6r", "6b"]
# result = ["5b", "5r", "7b", "8b", "8r"]
cards = ["6b", "7r", "7b"]
result = ["5b", "5r", "8b", "8r"]
# cards = ["1b", "4r", "3b"]
# result = ["1r", "2b"]
# cards = ["1r", "9b", "9r"]
# result = ["lose"]
print(solution(cards))
