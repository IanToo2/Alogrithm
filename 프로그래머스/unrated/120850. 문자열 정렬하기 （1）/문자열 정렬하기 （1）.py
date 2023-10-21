def solution(my_string):
    answer = []
    for i in range(len(my_string)):
        if 48 <= (ord(my_string[i])) and  (ord(my_string[i]))<= 57:
            print(my_string[i])
            answer.append(int(my_string[i]))

    return sorted(answer)