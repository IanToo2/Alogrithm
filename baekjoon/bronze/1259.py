while True:
    a = int(input())
    if a == 0:
        break
    
    if list(str(a)) == list(reversed(str(a))):
        print("yes")
    else:
        print("no") 