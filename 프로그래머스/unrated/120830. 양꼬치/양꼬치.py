def solution(n, k):
    answer = 12000 * n + 2000 * k
    answer = answer - 2000*(n//10)
    return answer