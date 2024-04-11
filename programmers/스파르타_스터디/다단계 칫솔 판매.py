# https://school.programmers.co.kr/learn/courses/30/lessons/77486

from collections import defaultdict


def solution(enroll, referral, seller, amount):
    answer = []
    enrollReferral = defaultdict(list)
    for e, r in zip(enroll, referral):
        enrollReferral[e].append(r)
    sellerAmount = dict()
    for s, a in zip(seller, amount):
        sellerAmount[s] = a * 100
    print(enrollReferral)

    return answer


enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["young", "john", "tod", "emily", "mary"]
amount = [12, 4, 2, 5, 10]
# result = [360, 958, 108, 0, 450, 18, 180, 1080]
print(
    solution(enroll,
             referral,
             seller,
             amount)
)
