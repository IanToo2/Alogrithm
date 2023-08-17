# 내가 짠 코드는 백준에서 시간 초과 발생
# def fib(n):
#     if n == 0:
#         return 0
#     elif n == 1 or n == 2:
#         return 1
#     else:
#         return fib(n - 1) + fib(n - 2)
# print(fib(n))

a = int(input())

fibonacci = []
num = 0

for i in range(a+1):
    if i == 0:
        num = 0
    elif i <= 2:
        num = 1
    else:
        num = fibonacci[-1] + fibonacci[-2]
    fibonacci.append(num)

print(fibonacci[-1])  