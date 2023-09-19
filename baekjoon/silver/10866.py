import sys
from collections import deque

deq = deque()

N = int(input())

def push_front(data):
    deq.appendleft(data)

def push_back(data):
    deq.append(data)

def pop_front():
    if size() == 0:
        print("-1")
    else:
        x = deq.popleft()
        print(x)

def pop_back():
    if size() == 0:
        print("-1")
    else:
        x = deq.pop()
        print(x)
        
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



while N!=0:
    work = sys.stdin.readline().split()

    if work[0] == "push_front":
        push_front(work[1])
    if work[0] == "push_back":
        push_back(work[1])    
    if work[0] == "front":
        front()
    if work[0] == "back":
        back()
    if work[0] == "size":
        print(size())
    if work[0] == "empty":
        empty()
    if work[0] == "pop_front":
        pop_front()
    if work[0] == "pop_back":
        pop_back()

    N-=1