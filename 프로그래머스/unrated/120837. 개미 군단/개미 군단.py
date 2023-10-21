def solution(hp):
    answer = 0
    damage = [5,3,1]
    for i in damage:
        answer += hp//i
        hp = hp%i
        
    return answer