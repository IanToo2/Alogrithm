from collections import deque

k = int(input())
q = deque()

while k!=0:
    order_num = int(input())
    if order_num == 0:
        q.pop()
    else:
        q.append(order_num)
    k-=1

print(sum(q))