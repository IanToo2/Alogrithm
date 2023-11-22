import sys

memo={}
def fibo(n):
    if n in memo:
        return memo[n]
    elif n == 1:
        result = 1
    elif n == 0:
        result = 0
    else:
        result = fibo(n-1) + fibo(n-2)

    memo[n] = result

    return result

t = int(sys.stdin.readline())

print(fibo(t))