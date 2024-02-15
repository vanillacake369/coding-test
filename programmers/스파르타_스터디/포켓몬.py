def solution(nums):
    p = set()
    for n in nums:
        p.add(n)
    if(len(p) > len(nums)/2) :
        return len(nums)/2
    else :
        return len(p)