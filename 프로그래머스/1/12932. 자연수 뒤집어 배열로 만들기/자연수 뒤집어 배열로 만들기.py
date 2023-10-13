def solution(n):
    answer = []
    
    for i in range(len(str(n))):
        answer.append(int(((str(n)[-i-1]))))

    return answer