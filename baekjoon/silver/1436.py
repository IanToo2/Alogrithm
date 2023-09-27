import sys
n = int(sys.stdin.readline())

start = 666 # 제일 처음 666이 들어가는 변수
count = 0 # 몇번째 666이 들어가는지 확인을 위한 변수

while True:

    # 666이 포함되는 경우
    if '666' in str(start):
        count += 1

        # 종료하는 시점
        if count == n:
            print(start)
            break

    start += 1