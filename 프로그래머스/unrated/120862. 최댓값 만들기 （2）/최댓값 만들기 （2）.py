def solution(numbers):
    answer = 0
    numbers = sorted(numbers)
    a = numbers[-1] * numbers[-2]
    b = numbers[0] * numbers[1]
    if a>b:
        answer = a
    else:
        answer = b
    return answer