def solution(num, total):
    answer = []
    start_num = 0
    while True:
        sum = 0

        for i in range(start_num,start_num+num):
            sum += i

        if sum == total:
            for i in range(start_num, start_num+num):
                answer.append(i)
            break
        elif sum > total:
            start_num -= 1
        else:
            start_num += 1

    return answer