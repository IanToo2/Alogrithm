def solution(x, n):
    answer = []
    add = x
    for i in range(n):
        answer.append(x)
        x += add
        
    return answer