def solution(angle):
    if 0<angle<90:
        answer = 1
    elif angle == 90:
        answer =2
    elif angle == 180:
        answer = 4
    else:
        answer = 3
    return answer