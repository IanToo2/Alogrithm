import sys

N, M = map(int, sys.stdin.readline().split())
data = set()
answer_set = set()

for i in range(N + M):
    check = sys.stdin.readline().strip()
    if check in data:
        answer_set.add(check)
    else:
        data.add(check)

answer = sorted(answer_set)

print(len(answer))
print(*answer, sep="\n")
