t = int(input())

for i in range(t):
    cnt = int(input())
    sum_a = 0.0
    sum_b = 0.0
    for i in range(cnt):
        a, b = map(float, (input().split()))

        sum_a += a
        sum_b += a*b
        
    print(int(sum_a), round((sum_b/sum_a),1))