def solution(x):
    
    answer = True
    str_x = str(x)
    test =0
    for i in range(len(str_x)):
        test += int(str_x[i])
    if x % test == 0:
        return answer
    else:
        answer = False
        return answer
