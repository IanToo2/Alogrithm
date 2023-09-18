N = int(input())

def factorial(N):
    if N == 1:
        return 1
    return N * factorial(N-1)

result = factorial(N)
print("int result : {}".format(result))
print("")

str_result = list(reversed(str(result)))
i = 0   
count = 0

while True:
    print("len of str_result :", len(str_result))
    print("now count size :", count)
    print("")
    if i >= len(str_result):
        print("count : ",count)
        break

    if str_result[i] != "0":
        print("count : ",count)
        break
    else:
        count+=1

    i +=1