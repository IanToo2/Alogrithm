# 과자의 값 K
# 과자의 개수 N
# 가진 돈 M

K,N,M = map(int, input().split())

if(K*N <= M):
    print("0")
else:
    print(K*N-M)