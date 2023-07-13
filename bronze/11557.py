T = int(input())
# 케이스 입력만큼 for문
for i in range(T):
    N = int(input())
    # 사용 되는 변수들 초기화
    인덱스저장 = 0
    대소비교용 = 0
    total = []
    # N개 만큼 입력 받기
    for j in range(N):
        # 리스트에 입력받고 새롭게 입력받기전에 초기화
        임시저장=[]
        임시저장=list(input().split())
        # total이란 변수에 저장
        total.append(임시저장)
    # 입력 받은 값들 크기 비교
    for k in range(len(total)):
        if int(total[k][1]) > 대소비교용:
            # 인덱스 값 저장
            대소비교용 = int(total[k][1])
            인덱스저장 = k
    # 인덱스가 가리키는 위치의 값 추출
    print(total[인덱스저장][0])