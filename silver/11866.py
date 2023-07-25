import sys

input = sys.stdin.readline

n, k = map(int, input().split())
people = [i for i in range(1, n+1)]
check_num = 0
result=[]

while True:
    print("\n")
    print(people)
    if len(result) == n:
        break
    check_num += 3

    if check_num >7:
        check_num -= 7

    if people[check_num-1] != 0:
        print("현재 check_num = {}".format(check_num))
        result.append(people[check_num-1])
        print("지워질 번호 = {}".format(people[check_num-1]))
        people[check_num-1] = 0

print(result)