import heapq
import sys
input = sys.stdin.readline
heap =[]

t = int(input())

for i in range(t):
    input_data = int(input())

    if input_data == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print("0")
    else:
        heapq.heappush(heap, input_data)
