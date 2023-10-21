def GCD(x,y):
    while (y):
        x,y= y,x%y
    return x

def LCM(x,y):
    result=(x*y)//GCD(x,y)
    return result

def solution(n):
    answer = 0
    if n > 6:
        result = LCM(n,6)
    else:
        result =LCM(6,n)
    
    answer = result//6
    
    return answer