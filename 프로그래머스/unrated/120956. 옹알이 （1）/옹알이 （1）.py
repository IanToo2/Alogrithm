def solution(babbling):
    answer = 0
    data = ["aya", "ye", "woo", "ma"]
    
    for i in babbling:
        print("Before Replace : {}".format(i))
        for j in data:
            if j in i:
                i = i.replace(j,'#')
                print("After Replace : {}".format(i))
            if list(set(i))[0] == "#" and list(set(i))[-1] == "#":
                break

        if list(set(i))[0] == "#" and list(set(i))[-1] == "#":
            answer += 1
            
    return answer