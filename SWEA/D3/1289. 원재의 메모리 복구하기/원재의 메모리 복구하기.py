t = int(input())

for i in range(1,t+1):

    memory = list(input())
    reset = ['0'] * len(memory)
    answer = 0
    for j in range(len(memory)):
        if memory[j] != reset[j]:
            for k in range(j,len(memory)):
                reset[k] = memory[j]
            answer += 1


    print("#{} {}".format(i, answer))