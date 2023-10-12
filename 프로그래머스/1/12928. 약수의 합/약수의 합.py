
def solution(n):
    answer = 0
    count = 1
    while count <= n:
        
        if n % count == 0:
            answer += count
        count += 1
        
    return answer
