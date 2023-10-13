def solution(n):
    answer = 0
    n = str(n)
    
    for i in range(len(n)):
        print(n[i])
        answer += int(n[i])

    return answer