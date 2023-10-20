def solution(num_list):
    answer = []
    odd = 0
    eve = 0
    
    for i in num_list:
        if num_list!=0:
            if i%2 ==0:
                eve +=1
            else:
                odd +=1
    answer.append(eve)
    answer.append(odd)
    return answer