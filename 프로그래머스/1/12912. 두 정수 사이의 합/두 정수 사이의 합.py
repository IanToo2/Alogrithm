def solution(a, b):
    answer = 0
    if a == b:
        answer = a
    elif a < b:
        for i in range(a,b+1):
            answer += i        
    else:
        for i in range(b,a+1):
            answer += i
            
    print(answer)
    return answer