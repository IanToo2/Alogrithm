# 시작 점수
창영 = 상덕 = 100
# 라운드 수
n = int(input())
# 주사위 굴리기
for _ in range(n):
    창영주사위, 상덕주사위 = map(int, input().split())
    if 창영주사위 > 상덕주사위:
        상덕 -= 창영주사위
    elif 창영주사위 < 상덕주사위:
        창영 -= 상덕주사위
# 결과값
print(창영)
print(상덕)