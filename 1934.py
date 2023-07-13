케이스 = int(input())
정답 = []
for i in range(케이스):
    a, b = map(int, input().split())
    testa,testb=a,b
    while(a%b!=0):
        a,b = b,a%b
    정답.append(int(testa*testb/b))
print(*정답, sep='\n')