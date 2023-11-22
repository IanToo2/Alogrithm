
t = int(input())
for _ in range(t):
    q = list(map(int, input().split()))
    q = list(sorted(q))
    del q[0]
    del q[-1]

    if q[-1] - q[0] >= 4:
        print("KIN")
    else:
        print(sum(q))
