import sys
from collections import deque

deq = deque()

N = int(input())

def push(data):
    deq.append(data)

def front():
    if size() != 0 :
        print(deq[0])
    else:
        print("-1")

def back():
    if size() != 0 :
        print(deq[-1])
    else:
        print("-1")

def size():
    return (len(deq))

def empty():
    if size() == 0:
        print("1")
    else:
        print("0")

def pop():
    if size() == 0:
        print("-1")
    else:
        x = deq.popleft()
        print(x)

while N!=0:
    work = sys.stdin.readline().split()

    if work[0] == "push":
        push(work[1])
    if work[0] == "front":
        front()
    if work[0] == "back":
        back()
    if work[0] == "size":
        print(size())
    if work[0] == "empty":
        empty()
    if work[0] == "pop":
        pop()

    N-=1