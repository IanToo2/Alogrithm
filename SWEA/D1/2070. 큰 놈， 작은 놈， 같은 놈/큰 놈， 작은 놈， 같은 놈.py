n =int(input())
i = 1
while True:
    if n < i:
        break
        
    a, b = map(int, input().split())

    if a == b:
        print("#{} =".format(i))
    elif a>b:
        print("#{} >".format(i))
    else:
        print("#{} <".format(i))
    i += 1