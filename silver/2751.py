# 입력받는 방식의 변화.....................
# 자꾸 시간초과떠서 뭐가 문제인지 한참 고민해봤다........
import sys

N = int(input())
A = []

for i in range(N):
    A.append(int(sys.stdin.readline()))
A = sorted(A)
print(*A, sep = '\n')