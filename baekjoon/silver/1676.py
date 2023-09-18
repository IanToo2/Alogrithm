N = int(input())

def factorial(N):
    cal =1
    for i in range(1,N+1):
        cal = cal * i
    return cal
result = factorial(N)

str_result = list(reversed(str(result)))
i = 0   
count = 0

while True:

    if i >= len(str_result):
        print(count)
        break

    if str_result[i] != "0":
        print(count)
        break
    else:
        count+=1

    i +=1