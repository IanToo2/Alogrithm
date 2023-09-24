data = []
result = 0
data_dic = {
    'black' : [0,1],
    'brown' : [1,10],
    'red' : [2,100],
    'orange' : [3, 1000],
    'yellow' : [4, 10000],
    'green': [5, 100000],
    'blue': [6, 1000000],
    'violet': [7, 10000000],
    'grey': [8, 100000000],
    'white': [9, 1000000000],
}

for i in range(3):
    input_data = input()
    if i == 0:
        result = int(data_dic[input_data][0]) * 10
    if i == 1:
        result += int(data_dic[input_data][0])
    if i == 2:
        result = result * int(data_dic[input_data][1])

print(result)