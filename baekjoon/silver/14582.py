제미니스 = list(map(int, input().split()))
걸리버스 = list(map(int, input().split()))

제미니스합 = 0
걸리버스합 = 0
역전인가 = 0

i = 0
    
while True:
    
    if i == len(제미니스):
        break
    else:
        제미니스합 += 제미니스[i]
        if 제미니스합 > 걸리버스합:
            역전인가 +=1
            break
        걸리버스합 += 걸리버스[i]

        i+=1

if 역전인가 == 1:
    print("Yes")
elif 역전인가 != 1:
    print("No")