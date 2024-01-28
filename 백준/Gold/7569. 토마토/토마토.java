import java.io.*;
import java.util.*;

// 3가지 좌표로 다루기 위한 클래스
class Node {
	int x;
	int y;
	int z;

	Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	// 상, 하, 좌, 우, 위 , 아래 확인용 배열
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	// 토마토 값 저장용
	static int[][][] map;
	// 토마토 위치별 걸린 날짜 저장용
	static int[][][] dist;
	// 입력값을 받기위한 변수
	static int m, n, h;
	// bfs를 위한 Queue
	static Queue<Node> q = new LinkedList<Node>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();

		map = new int[h][n][m];
		// 걸린 날짜 저장용
		dist = new int[h][n][m];

		// 입력받기
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[k][i][j] = sc.nextInt();
					// 토마토가 익은 경우 q에 저장
					if (map[k][i][j] == 1)
						q.add(new Node(k, i, j));
				}
			}
		}
		// bfs
		while (!q.isEmpty()) {
			Node t = q.remove();

			int x = t.x;
			int y = t.y;
			int z = t.z;
			// 상, 하, 좌, 우 ,위 ,아래 6곳을 확인하기 위한 반복문
			for (int i = 0; i < dy.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				// 좌표값이 map안에 있는 경우
				if (0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m) {
					// 토마토가 존재하고 안익으면서 방문하지 않은 경우
					if (map[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
						// 새로운 값 q에 저장
						q.add(new Node(nx, ny, nz));
						// 걸린 날짜를 dist에 +1 한 값을 저장
						dist[nx][ny][nz] = dist[x][y][z] + 1;
					}
				}
			}
		}

		int answer = 0;
		// 날짜가 가장 큰 값을 answer에 저장
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (answer < dist[k][i][j])
						answer = dist[k][i][j];
				}
			}
		}

		// 토마토가 모두 익지는 못하는 상황이면 -1
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 안익은 토마토가 존재하고 해당 위치에 접근하지 못한 경우
					if (map[k][i][j] == 0 && dist[k][i][j] == 0) {
						answer = -1;
					}
				}
			}
		}

		System.out.println(answer);
	}
}