from itertools import combinations

data = []

for i in range(9):
    data.append(int(input()))

result = list(combinations(data, 7))

for i in result:
    if sum(i) == 100:
        i = sorted(i)
        print(*i, sep = "\n")
        break
