n = 1000 - int(input())

count = 0
money_list = [500, 100, 50, 10, 5, 1]

for i in money_list:
    if n == 0:
        break
    count = count + n // i
    n = n % i

print(count)