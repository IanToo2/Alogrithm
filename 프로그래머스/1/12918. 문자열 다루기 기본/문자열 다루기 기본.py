def solution(s):
    answer = False
    data = ['0','1','2','3','4','5','6','7','8','9']
    list_s = list(s)
    count = 0
    
    for i in list_s:
        if i in data:
            count+=1
            
    if count == len(list_s):
        if count == 4 or count == 6:
            answer = True
    
    return answer