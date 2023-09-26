N, K = map(int, input().split())

data = []

data.extend(map(int, input().split()))

print(list(sorted(data))[-K])

