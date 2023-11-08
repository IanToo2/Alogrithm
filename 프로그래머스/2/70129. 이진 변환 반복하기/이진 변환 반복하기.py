def solution(s):
    answer = []
    count = 0
    change_count = 0
    while True:
        if s == '1':
            break

        count += 1
        before_len_s = len(s)
        s = s.replace("0", "")

        after_len_s = len(s)

        change_count += before_len_s - after_len_s

        s = bin(int(len(s)))[2:]
    answer.append(count)
    answer.append(change_count)
        
    return answer