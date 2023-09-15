def init():
    global 거스름돈 ,쿼터 ,다임 ,니켈 ,페니
    거스름돈 = 쿼터 = 다임 = 니켈 = 페니 = 0

def 쿼터거스름돈():
    global 거스름돈
    쿼터값 = 거스름돈 // 25
    거스름돈 = 거스름돈 % 25
    return 쿼터값

def 다임거스름돈():
    global 거스름돈
    쿼터값 = 거스름돈 // 10
    거스름돈 = 거스름돈 % 10
    return 쿼터값

def 니켈거스름돈():
    global 거스름돈
    쿼터값 = 거스름돈 // 5
    거스름돈 = 거스름돈 % 5
    return 쿼터값

def 페니거스름돈():
    global 거스름돈
    쿼터값 = 거스름돈 // 1
    return 쿼터값

Testcount = int(input())

while Testcount:
    init()
    거스름돈 = int(input())

    쿼터 = 쿼터거스름돈()
    if 거스름돈 != 0:
        다임 = 다임거스름돈()
    if 거스름돈 != 0:
        니켈 = 니켈거스름돈()
    if 거스름돈 != 0:    
        페니 = 페니거스름돈()

    print(f"{쿼터} {다임} {니켈} {페니}")
    Testcount -= 1
