import sys
from collections import deque

que = deque()

N = int(input())


def insert_data(data : int):
    que.append(data)

def pop_que():
    if len(que) != 0:
        print(que[-1])
        que.pop()
    else:
        print("-1")
def print_len():
    print(len(que))

def check_que():
    if len(que) == 0:
        print("1")
    else:
        print("0")

def check_top():
    if len(que) != 0:
        print(que[-1])
    else:
        print("-1")


while N>0:
    order = sys.stdin.readline().split()
    if order[0] == "1":
        insert_data(order[1])
    if order[0] == "2":
        pop_que()
    if order[0] == "3":
        print_len()
    if order[0] == "4":
        check_que()
    if order[0] == "5":
        check_top()
    N -= 1