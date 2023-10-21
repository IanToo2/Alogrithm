import math

def recursive(answer,n,t):
    # 종료 조건
    if t==0:
        return answer
    
    return recursive(answer*2,n,t-1)

def solution(n, t):
    answer = n
    
    answer = recursive(answer,n,t)
    
    return answer