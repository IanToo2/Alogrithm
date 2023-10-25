from collections import deque
def solution(num_list, n):
    answer = []
    q = deque()
    for i in num_list:
        q.append(i)
        
    while True:
        test=[]
        if len(q) ==0:
            break
        for i in range(n):
            test.append(q.popleft())
            
        answer.append(test)
        
        
    return answer