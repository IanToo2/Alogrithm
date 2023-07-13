숫자 = int(input())

i = 2
while 숫자 > 1:
    if 숫자 % i == 0:
        숫자 = 숫자 / i
        print(i)
    else:
        i += 1