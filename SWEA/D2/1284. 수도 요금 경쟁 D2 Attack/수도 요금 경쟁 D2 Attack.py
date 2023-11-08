t = int(input())
i = 1

while i <= t:
    P, Q, R, S, W = map(int, input().split())

    A = P * W

    if W <= R:
        B = Q
    else:
        B = Q + (W-R)*S

    if A > B:
        print("#{} {}".format(i, B))
    else:
        print("#{} {}".format(i, A))

    i += 1