def solution(s):
    answer = ''
    sorted_s = sorted(list(s), reverse=True)
    input_last = ''
    for i in range(len(sorted_s)):
        if sorted_s[i].isupper():
            input_last += sorted_s[i]
        else:
            answer += sorted_s[i]
    answer += input_last
    return answer