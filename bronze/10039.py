점수 = []
for i in range(5):
    점수.append(int(input()))
    if(점수[i] < 40):
        점수[i] = 40
print(int(sum(점수)/5))

