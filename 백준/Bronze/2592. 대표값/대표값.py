sum = 0
data = {}
for i in range(10):
    input_data = int(input())
    sum += input_data
    if input_data in data:
        data[input_data] += 1
    else:
        data[input_data] = 0

print(sum//10)
print(max(data, key = data.get))