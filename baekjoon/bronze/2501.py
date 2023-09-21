a, b = map(int, input().split())
i = 1
data = []
while i<=a:

    if a % i == 0:
        data.append(i)
    i+=1

if len(data) < b:
    print("0")
else:
    print(data[b-1])