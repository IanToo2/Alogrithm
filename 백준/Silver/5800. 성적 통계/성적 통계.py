t = int(input())

for _ in range(1,t+1):

    data = list(map(int,input().split()))
    del data[0]
    data = sorted(data, reverse = True)

    max = 0
    for i in range(len(data)-1):
        if data[i] - data[i+1] > max:
            max = data[i] - data[i+1]
    print("Class {}".format(_))
    print("Max {}, Min {}, Largest gap {}".format(data[0],data[-1],max))