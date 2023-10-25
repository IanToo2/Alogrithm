def solution(my_string):
    answer = 0
    num=0
    for i in my_string:
        if i.isdigit():
            num=num*10+int(i)    
        else :
            answer+=num
            num=0
    answer+=num
    return answer