from collections import Counter
def solution(array):
    answer = 0
    dic_arr = dict(Counter(array))
    max_val = max(dic_arr.values())
    
    for k,v in dic_arr.items():
        if v == max_val:
            if answer == 0:
                answer = k
            else:
                answer = -1
    return answer