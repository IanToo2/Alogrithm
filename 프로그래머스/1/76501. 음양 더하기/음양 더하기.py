def solution(absolutes, signs):
    answer = 0
    total_len = len(signs)
    
    for i in range(total_len):
        if not signs[i]:
            answer -= absolutes[i]
        else:
            answer += absolutes[i]
    
    return answer