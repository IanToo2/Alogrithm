def recursive(a, b):
    if b == 1:
        return a
    return recursive(a, b-1) * a

for i in range(1, 11):

    num = int(input())

    a, b = map(int, input().split())

    answer = recursive(a, b)
    print("#{} {}".format(num, answer))