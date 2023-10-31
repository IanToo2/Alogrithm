def solution(s):
    answer = ''
    list_s = list(s)
    test = ''
    data_list=['zero','one','two','three','four','five','six','seven','eight','nine']


    for i in list_s:
        if 48 <= ord(i) <= 57:
            answer += i
        else:
            test += i
            
        if test in data_list:
            answer += str(data_list.index(test))
            test = ''
            
    return int(answer)