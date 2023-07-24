import sys
# 입력 받는 문자열 길이
n = int(sys.stdin.readline().strip())

# 문자열 입력
test = list(map(str, sys.stdin.readline().strip()))
result = 0

for i in range(len(test)):
    result += (ord(test[i])-96) * 31**i
    # print("{}번째 항 : {}".format(i, result))

print(result)