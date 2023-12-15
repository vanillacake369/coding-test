# https://velog.io/@wjdtmdgml/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EB%A9%80%EB%A6%AC%EB%9B%B0%EA%B8%B012914%EB%B2%88Python%ED%8C%8C%EC%9D%B4%EC%8D%ACDP

def solution(n):
    if n<3:
        return n
    d=[0]*(n+1)
    d[1]=1
    d[2]=2
    for i in range(3,n+1):
        d[i]=d[i-1]+d[i-2]
    return d[n]%1234567