a, b = map(int, input().split())

data = [x + 1 for x in range(a)]
answer = []
cur = -1

while len(data) != 0:
    cur += b
    
    # 수정된 부분: cur이 리스트 길이보다 클 경우를 처리
    if cur >= len(data):
        cur = cur % len(data)

    answer.append(data[cur])
    del data[cur]

    # 수정된 부분: cur이 음수일 경우를 처리
    cur -= 1 if cur >= 0 else 0

print("<", end='')
print(*answer, sep=', ', end='')
print(">")
