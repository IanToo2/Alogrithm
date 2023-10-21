def solution(cipher, code):
    answer = ''
    start = code -1
    while True:
        if start >= len(cipher):
            return answer
        answer += cipher[start]
        start+=code
    
    return answer