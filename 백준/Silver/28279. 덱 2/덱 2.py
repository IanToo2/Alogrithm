import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque()

while n != 0:
    a = list(map(int, sys.stdin.readline().split()))
    if a[0] == 1:
        q.appendleft(a[1])
    elif a[0] == 2:
        q.append(a[1])
    elif a[0] == 3:
        if not q:
            print(-1)
        else:
            print(q.popleft())
    elif a[0] == 4:
        if not q:
            print(-1)
        else:
            print(q.pop())
    elif a[0] == 5:
        print(len(q))
    elif a[0] == 6:
        if not q:
            print(1)
        else:
            print(0)
    elif a[0] == 7:
        if not q:
            print(-1)
        else:
            print(q[0])
    elif a[0] == 8:
        if not q:
            print(-1)
        else:
            print(q[-1])
    n -= 1