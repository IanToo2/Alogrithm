data = []

for i in range(5):
    data.append(int(input()))
# 평균 출력
print(int(sum(data)/len(data)))

# 중앙값 출력
print(sorted(data)[2])