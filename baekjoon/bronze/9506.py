# 1. 약수구하기
# 2. 1 추가하기
# 3. 정렬
# 4. 합으로 입력값과 비교
while True:
    a = int(input())
    if a == -1:
        break
    b = []
    for i in range(2,a):
        if i > a/2:
            break
        if a%i == 0:
            b.append(i)
    b.append(1)
    b = sorted(b)
    if sum(b) == a:
        print(a,"=", end = " ")
        print(*b, sep =" + ")
    else:
        print("{} is NOT perfect.".format(a))