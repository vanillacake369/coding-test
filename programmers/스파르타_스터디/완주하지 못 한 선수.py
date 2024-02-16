# #1
# def solution(participant, completion):
#     sp = sorted(participant)
#     sc = sorted(completion)
#     for idx,s in enumerate(sc):
#         if(sp[idx] != s):
#             return sp[idx]
#     return sp[len(sp)-1]

# #2 
def solution(participant, completion):
    hashP = dict()
    sum = 0

    for p in participant:
        hashP[hash(p)] = p
        sum += hash(p)

    for c in completion:
        sum -= hash(c)

    return hashP[sum]


participant = ["leo", "kiki", "eden"]	
completion = ["eden", "kiki"]	
result = solution(participant,completion)
print(result)