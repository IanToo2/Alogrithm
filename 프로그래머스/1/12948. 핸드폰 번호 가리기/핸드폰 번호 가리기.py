def solution(phone_number):
    answer = ''
    길이 = len(phone_number)
    for i in range(길이-4):
        answer += "*"
    answer += phone_number[-4]
    answer += phone_number[-3]
    answer += phone_number[-2]
    answer += phone_number[-1]
    
    return answer