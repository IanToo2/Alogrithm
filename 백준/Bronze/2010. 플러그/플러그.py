import sys
input = sys.stdin.readline
t = int(input())
sum = 0
for i in range(t):
    sum += int(input())

print(sum - t+1)