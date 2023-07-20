# 이항 계수 구하기
# dp 알고리즘 이용
def binomial_coefficient(n, k):
    if k == 0 or k == n:
        return 1
    
    dp = [[0] * (k + 1) for _ in range(n + 1)]
    for i in range(n + 1):
        dp[i][0] = 1
    for i in range(1, n + 1):
        for j in range(1, min(i, k) + 1):
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
    
    return dp[n][k]

n, k = map(int,input().split())
result = binomial_coefficient(n, k)
print(result)
