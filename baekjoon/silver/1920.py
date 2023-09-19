N = input()
N_case = set(map(int, input().split()))

M= input()
M_case = list(map(int, input().split()))

for i in M_case:
    if i in N_case:
        print("1")
    else:
        print("0")