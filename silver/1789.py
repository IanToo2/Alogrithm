S = int(input())
total = 0
N = 0

while True:
    N += 1
    total += N
    if total > S:
        break

print(N-1)