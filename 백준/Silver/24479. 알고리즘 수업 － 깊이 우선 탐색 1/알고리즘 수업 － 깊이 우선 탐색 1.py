import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m, r = map(int, input().split())

# DFS 사용을 위한 2중배열과 방문배열 초기화
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

cnt = 1

def dfs(graph, v, visited):
    global cnt
    # 방문 순서 확인
    visited[v] = cnt

    for i in graph[v]:
        # 재귀 호출 조건
        if visited[i] == 0:
            cnt += 1
            dfs(graph, i, visited)


# 그래프 값 입력 받기
for i in range(m):
    a, b = (map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

# 그래프 정렬하기
for i in range(n + 1):
    graph[i].sort()

dfs(graph, r, visited)

for i in range(1, n + 1):
    print(visited[i])
