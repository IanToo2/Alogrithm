import sys

N, M = map(int, sys.stdin.readline().split())
data = set()  # 중복을 허용하지 않는 집합으로 변경
answer_set = set()  # 중복된 값만 저장하는 집합

for i in range(N + M):
    check = sys.stdin.readline().strip()  # 줄 끝의 개행 문자 제거
    if check in data:  # 이미 등장한 문자인지 확인
        answer_set.add(check)  # 중복된 값만 저장하는 집합에 추가
    data.add(check)  # 중복을 허용하지 않는 집합에 추가

answer = sorted(answer_set)  # 중복된 값을 정렬하여 리스트로 변환

print(len(answer))
print(*answer, sep="\n")
