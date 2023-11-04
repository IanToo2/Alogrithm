def solution(my_string):
    answer = 0
    data = list(my_string.split())
    print(data)
    check = 0
    for i in data:
        if i == '+':
            check = 0
        elif i == '-':
            check = 1
        else:
            if check == 0:
                answer += int(i)
            else:
                answer -= int(i)
    return answer