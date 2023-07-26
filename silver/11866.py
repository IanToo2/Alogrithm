# 빠른 입력을 위한 sys 사용
import sys

input = sys.stdin.readline

n, k = map(int, input().split())
# 인덱스에 접근할 변수
count = 0
# n의 크기의 리스트 생성
people = [i for i in range(1, n+1)]
# 결과를 저장할 리스트
result = []

# 요세푸스 순열 시작
while people:
    
    count += k - 1
    
    if count >= len(people):
        count %= len(people)
    
    result.append(str(people.pop(count)))

print("<", ", ".join(result), ">", sep="")