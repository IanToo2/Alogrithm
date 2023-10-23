def solution(numbers):
    answer = ''
    sorted_numbers = sorted(map(str, numbers), key=lambda x: x*4, reverse=True)
    #print(sorted_numbers)
    for i in sorted_numbers:
        answer += i
    if sorted_numbers[0] == '0':
        answer = '0'
    return answer