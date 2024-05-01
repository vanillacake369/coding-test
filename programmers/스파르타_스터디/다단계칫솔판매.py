# def calculateBenefits(eachSeller, eachAmount, parentsTree, finalBenefitTree):
#     parentsTree[eachSeller] = math.floor(eachAmount * 0.09)
#     if parentsTree[eachSeller] == "-":
#         return
#     calculateBenefits(parentsTree[eachSeller], math.floor(eachAmount * 0.01), parentsTree, finalBenefitTree)


def solution(enroll, referral, seller, amount):
    finalBenefitTree = {}
    for eachEnroll in enroll:
        finalBenefitTree[eachEnroll] = 0
    parentsTree = {}
    for eachEnroll, eachReferral in zip(enroll, referral):
        parentsTree[eachEnroll] = eachReferral
    for eachSeller, eachAmount in zip(seller, amount):
        nextSeller = eachSeller
        eachAmount = eachAmount * 100
        while nextSeller in parentsTree and eachAmount > 0:
            finalBenefitTree[nextSeller] += eachAmount - eachAmount // 10
            eachAmount //= 10
            nextSeller = parentsTree[nextSeller]
    return list(finalBenefitTree.values())


# 부모에게 10% 떼고 나머지 90%는 자신이 가짐
# enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]  # 판매원
# referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]  # 각 판매원의 부모
# seller = ["young", "john", "tod", "emily", "mary"]
# amount = [12, 4, 2, 5, 10]
# result = [360, 958, 108, 0, 450, 18, 180, 1080]
enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]  # 판매원
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]  # 각 판매원의 부모
seller = ["sam", "emily", "jaimie", "edward"]
amount = [2, 3, 5, 4]
result = [0, 110, 378, 180, 270, 450, 0, 0]
print(solution(enroll, referral, seller, amount))
