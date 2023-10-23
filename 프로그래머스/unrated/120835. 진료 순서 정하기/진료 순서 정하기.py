def solution(emergency):
    result = []
    sorted_e = sorted(emergency, reverse=True)
    # print(sorted_e)
    for i in range(len(emergency)):
        
        result.append(sorted_e.index(emergency[i])+1)
    # print(emergency.index(sorted_e[i]))
    return result
