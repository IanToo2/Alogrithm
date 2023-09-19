import sys

N = int(sys.stdin.readline())
my_dict = {}

for i in range(N):
    age, name = map(str, sys.stdin.readline().split())
    my_dict[name] = age

# 값(Value)을 기준으로 정렬
sorted_dict = dict(sorted(my_dict.items(), key=lambda item: item[1]))

for key, value in sorted_dict.items():
    print("{} {}".format(value, key))
