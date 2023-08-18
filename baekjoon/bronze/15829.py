import sys
# 입력 받는 문자열 길이
n = int(sys.stdin.readline().strip())

# 문자열 입력
test = list(map(str, sys.stdin.readline().strip()))
# 최종 결과 값이 저장 될 변수 선언
result = 0

for i in range(len(test)):
    # ord 함수로 저장된 문자를 유니코드로 변경하고 연산을 수행
    result += (ord(test[i])-96) * 31**i
    # 각 항 결과를 확인해보는 코드
    # print("{}번째 항 : {}".format(i, result))

print(result % 1234567891)