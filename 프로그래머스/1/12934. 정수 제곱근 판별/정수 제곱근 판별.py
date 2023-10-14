def solution(n):
    answer = 0
    a = n ** (1/2)
    if a%1 == 0:
        answer = (int(a)+1) **2
        print(answer)
    else:
        answer = -1
    return answer