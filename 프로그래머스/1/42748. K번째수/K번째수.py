def solution(array, commands):
    answer = []
    
    for i in commands:
        # print(array)
        # print("i[0],i[1] : {},{}".format(i[0]-1,i[1]))
        test =array[i[0]-1:i[1]]
        # print("정렬 전 :{}".format(test))
        sorted_a = sorted(test)
        # print("정렬 후 :{}".format(sorted_a))
        # print("{}에 위치한 값 : {}".format(i[2],sorted_a[i[2]-1]))
        answer.append(sorted_a[i[2]-1])
              
    return answer