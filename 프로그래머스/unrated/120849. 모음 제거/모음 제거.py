def solution(my_string):
    answer = ''
    list_my_string = list(my_string)
    remove_data = ['a', 'e', 'i', 'o', 'u']
    for i in range(5):
        while remove_data[i] in list_my_string:
            list_my_string.remove(remove_data[i])
    
    for i in list_my_string:
        answer += i
    
    return answer
