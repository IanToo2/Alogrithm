def solution(before, after):
    answer = 0
    list_b = list(before)
    list_a = list(after)
    for i in range(len(list_b)):
        if list_b[i] in list_a:
            list_a.remove(list_b[i])
    if len(list_a) == 0:
        answer = 1
    else:
        answer = 0
    return answer