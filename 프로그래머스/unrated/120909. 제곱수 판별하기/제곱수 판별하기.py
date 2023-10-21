import math

def solution(n):
    answer = 0
    if math.sqrt(n).is_integer():
        answer =1
    else:
        answer =2
    return answer