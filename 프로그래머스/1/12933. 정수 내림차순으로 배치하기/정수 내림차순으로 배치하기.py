def solution(n):
    answer = 0
    n = list(str(n))
    n = sorted(n, reverse=True)
    test = ''
    for i in range(len(n)):
        test = test + n[i]
    answer=int(test)
    return answer