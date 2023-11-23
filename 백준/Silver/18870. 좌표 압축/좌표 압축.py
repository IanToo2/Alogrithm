import sys

input = sys.stdin.readline

t = int(input())

data_list = list(map(int, input().split()))

# 중복 제거 및 정렬
set_list = sorted(list(set(data_list)))

# 딕셔너리를 사용하여 값의 인덱스 매핑
index_dict = {value: index for index, value in enumerate(set_list)}

# 결과 출력
for value in data_list:
    print(index_dict[value], end=' ')
