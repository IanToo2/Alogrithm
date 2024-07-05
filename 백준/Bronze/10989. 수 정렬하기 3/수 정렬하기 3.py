# sys.stdion.readline() 사용을 위한 import
import sys
# input()보다 빠른 sys.stdin.readline()을 사용
n = int(sys.stdin.readline())
# 메모리 재할당으로 인한 실패 해결을 위한 리스트 크기를 우선 선언한다.
num_list = [0] * 10001

# 입력되는 값이랑 같은 인덱스를 1증가 시켜 몇 번이나 그 수가 입력되었는지 확인
for _ in range(n):
    num_list[int(sys.stdin.readline())] += 1

# 리스트를 돌면서 인덱스에 들어있는 값만큼 해당 인덱스를 출력한다.
for i in range(10001):
    if num_list[i] != 0:
        for j in range(num_list[i]):
            print(i)