import sys
from collections import deque

deq = deque()

N = int(input())

def push(data):
    deq.append(data)


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
        x = deq.pop()
        print(x)

def top():
    if size() == 0:
        print("-1")
    else:
        print(deq[-1])
while N!=0:
    work = sys.stdin.readline().split()

    if work[0] == "push":
        push(work[1])
    if work[0] == "pop":
        pop()
    if work[0] == "size":
        print(size())
    if work[0] == "empty":
        empty()
    if work[0] == "top":
        top()


    N-=1