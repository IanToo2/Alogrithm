n = int(input())
a = list(map(int, input().split()))
count = 0

for _ in a:
  for i in range(2, _+1):
    if _ % i == 0:
      if _ == i:
        count += 1
      break

print(count)