data = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']

input_data = list(input())
input_data = list(reversed(input_data))

cnt = 0
sum= 0

for i in input_data:
    sum += (data.index(i) * (16 ** cnt))
    cnt += 1
print(sum)