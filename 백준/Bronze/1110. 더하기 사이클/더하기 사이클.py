start_num = int(input())
cnt = 0
logic_2 = '0'
while True:
    if int(logic_2) == start_num:
        if start_num == 0:
            print("1")
        else:
            print(cnt)
        break

    if cnt == 0:
        num = start_num
    else:
        num = int(logic_2)

    if num < 10:
        str_num = '0'+str(num)
    else:
        str_num = str(num)

    logic_1 = int(str_num[0]) + int(str_num[1])
    logic_2 = str_num[1] + str(logic_1)[-1]

    cnt +=1