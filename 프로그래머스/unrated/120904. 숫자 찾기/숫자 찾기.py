def solution(num, k):
    answer = -1
    str_num = str(num)
    
    for i in range(len(str_num)):
        if str_num[i] == str(k):
            answer = i+1
            break
    
    return answer
