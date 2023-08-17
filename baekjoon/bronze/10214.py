T = int(input())


while True:
    Y = K = 0

    if T == 0:
        break
    for _ in range(9):
        score_y, score_k = map(int, input().split())
        Y += score_y
        K += score_k
    if Y > K:
        print("Yonsei")
    elif K > Y:
        print("Korea")    
    
    T-=1

