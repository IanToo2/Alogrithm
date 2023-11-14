def solution(polynomial):
    answer = ''
    list_poly = list(polynomial.split(" + "))

    x_data = 0
    int_data = 0
    
    for i in list_poly:
        if i.isdecimal():
            int_data += int(i)
        else:
            if i == "x":
                x_data += 1
            else:
                x_data += int(i[:-1])

    if x_data == 0:
        if int_data == 0:
            answer =''
        else:
            answer = str(int_data)
    elif x_data == 1:
        if int_data == 0:
            answer = "x"
        else:
            answer = "x + {}".format(int_data)
    else:
        if int_data == 0:
            answer = "{}x".format(x_data)
        else:
            answer = "{}x + {}".format(x_data, int_data)

    return answer