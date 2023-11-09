from collections import deque
for _ in range(10):
    cnt = int(input())
    q = deque(map(int, input().split()))
    stop = 0
    
    while True:
        if stop == 1:
            break
        for i in range(1,6):
            check = q.popleft()
            if check - i > 0:
                q.append(check-i)
            else:
                q.append(0)
                stop = 1
                break
    print("#{} ".format(cnt), end = '')
    print(*q)