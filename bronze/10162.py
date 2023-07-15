T = int(input())
A = B = C = 0
검사용 = list(str(T))
while True:
    몫 = 나머지 = 0
    if T == 0 or int(검사용[-1]) != 0:
        break
    elif T >= 300:
        몫 = T // 300
        나머지 = T % 300
        A = 몫
        T = 나머지
    elif T >= 60 :
        몫 = T // 60
        나머지 = T % 60
        B = 몫
        T = 나머지
    elif T >= 10 :
        몫 = T // 10
        나머지 = T % 10
        C = 몫
        T = 나머지
    print("{} {} {}".format(A,B,C))

if(검사용[-1] != "0"):
    print("-1")