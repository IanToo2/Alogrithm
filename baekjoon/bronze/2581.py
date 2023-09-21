M = int(input())
N = int(input())
data = []
count = 0

def is_prime(num):
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

min_prime = None
for i in range(M, N + 1):
    if is_prime(i):
        data.append(i)
        if min_prime is None or i < min_prime:
            min_prime = i

if len(data) == 0:
    print("-1")
else:
    print(sum(data))
    if min_prime is not None:
        print(min_prime)
