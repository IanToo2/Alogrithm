X = int(input())

i = 1

while X>i:

    X -= i
    i+=1

if i%2 == 0:
    분모 = X
    분자 = i-X+1
else:
    분모 = i-X+1
    분자 = X

print("{}/{}".format(분모,분자))