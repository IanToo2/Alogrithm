from collections import deque

def solution(s):
    answer = True
    total_len = len(s)

    
    if s[0] == ')':
        answer = False
        return answer
    
    q= deque()
    r= deque()
    
    for i in s:
        if i == ')':
            r.append(i)
        else:
            q.append(i)
        
        if len(q) < len(r):
            return False
        
        if len(r) > total_len/2:
            return False
        if len(q) > total_len/2:
            return False

    if len(r) != len(q):
        answer = False
        return answer
    
    return True