def solution(price, money, count):
    answer = -1
    total_cost = 0
    for i in range(count):
        total_cost += price*(i+1)
        
    answer = total_cost - money
    if answer < 0:
        answer = 0
        
    return answer