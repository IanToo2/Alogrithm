케이스 = int(input())

for i in range(케이스):
    점수, 연속  = 0, 0
    결과 = []
    결과 = list(input())
    for j in range(len(결과)):
        if 결과[j] == "O":
            점수 = 점수 + 연속 + 1
            연속 += 1
        elif 결과[j] == "X":
            연속 = 0
    print(점수)
