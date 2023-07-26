import sys

input = sys.stdin.readline

n, k = map(int, input().split())

# 요세푸스 순열 생성
count = 0
# n의 크기의 리스트 생성
people = [i for i in range(1, n+1)]
# 결과를 저장할 리스트
result = []

while people:
    
    count += k - 1
    
    if count >= len(people):
        count %= len(people)
    
    result.append(str(people.pop(count)))

print("<", ", ".join(result), ">", sep="")