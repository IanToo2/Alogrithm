x, y, w, h = map(int, input().split())

# x랑 w비교, y랑 h 비교
a = b = 0

if w-x > x:
    a = x
else:
    a = w-x

if h-y > y:
    b = y
else:
    b = h-y

if a > b:
    print(b)
else:
    print(a)