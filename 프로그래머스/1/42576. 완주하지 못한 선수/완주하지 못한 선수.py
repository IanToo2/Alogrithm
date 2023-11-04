def solution(participant, completion):
    answer = ''
    
    p = sorted(participant)
    c = sorted(completion)
    
    for a, b in zip(p,c):
        if a!=b:
            return a
    
    return p[-1]