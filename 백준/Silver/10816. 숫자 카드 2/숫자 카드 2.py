import sys
from collections import Counter

N = int(sys.stdin.readline())
N_card = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
M_card = list(map(int, sys.stdin.readline().split()))

C = Counter(N_card)

for i in M_card:
    if i in C:
        print(C[i], end=" ")
    else:
        print("0", end=" ")
