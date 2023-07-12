
테스트케이스수=int(input())
돌아가자 = 0
while(돌아가자<테스트케이스수):
    수학식 = []
    결과 = 0.0

    수학식 = input().split()

    for i in range(len(수학식)):

        if (수학식[i] == "@"):
            결과 *= 3
        elif (수학식[i] == "%"):
            결과 += 5
        elif (수학식[i] == "#"):
            결과 -= 7
        else:
            결과 += float(수학식[i])

    print("{:.2f}".format(결과))
    돌아가자 += 1
