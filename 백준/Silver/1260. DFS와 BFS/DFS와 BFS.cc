#include <iostream>
#include <string.h>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int c[1001];    //정점에 방문했는지 체크하는 배열
vector<int> a[1001];    //그래프 정보 저장하는 벡터

//처음 그래프를 구성할 때에 에지를 추가하는 함수
void insert_edge(int i, int j) {
	a[i].push_back(j);		//양방향 에지
	a[j].push_back(i);
}

void bfs(int start) {
	queue<int> q;
	q.push(start);
	c[start] = true;

	while (!q.empty()) {
		int w = q.front();
		q.pop();
		cout << w << ' ';
		for (int i = 0; i < a[w].size(); i++) {
			int y = a[w][i];
			if (!c[y]) {
				q.push(y);
				c[y] = true;
			}
		}
	}
}

void dfs(int n) {
	if (c[n]) return;

	cout << n << ' ';
	c[n] = true;
	for (int i = 0; i < a[n].size(); i++) {
		int y = a[n][i];
		if (!c[y])
			dfs(y);
	}
}

int main(void) {
	int N, M, V, x, y;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		cin >> x >> y;
		insert_edge(x, y);    //에지 추가
	}

	for (int i = 1; i <= N; i++) {		//정점이 작은 것부터 방문하도록
		sort(a[i].begin(), a[i].end());
	}

	dfs(V);
	cout << endl;
	memset(c, 0, sizeof(c));    //정점에 방문했는지 체크하는 배열 초기화
	bfs(V);
	cout << endl;
}