import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	static int minX, minY, maxX, maxY;
	static boolean[][] map = new boolean[101][101];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;
	static Person person;

	static class Person {
		int x = 50;
		int y = 50;
		int dict = 2;
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
		checkMap();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		person = new Person();

		char[] order = br.readLine().toCharArray();
		map[person.x][person.y] = true;
		minX = minY = maxX = maxY = 50;
		for (int i = 0; i < n; i++) {
			char now = order[i];
			if (now == 'F') {
				if (person.dict == 0) {
					person.x--;
				} else if (person.dict == 1) {
					person.y++;
				} else if (person.dict == 2) {
					person.x++;
				} else {
					person.y--;
				}
			} else if (now == 'L') {
				person.dict--;
				if (person.dict == -1) {
					person.dict = 3;
				}
			} else {
				person.dict = (person.dict + 1) % 4;
			}
			map[person.x][person.y] = true;
			checkMinMax();
		}
	}

	private static void run() throws Exception {

	}
	private static void checkMap() {
//		System.out.println(minX + " , "  + minY);
//		System.out.println(maxX + " , "  + maxY);
		for(int i = minX ; i <= maxX;i ++) {
			for(int j = minY ; j <= maxY;j++) {
//				System.out.print(map[i][j] + " ");
				if(map[i][j]==true) {
					System.out.print('.');
				}else {
					System.out.print('#');
				}
			}System.out.println();
		}
	}
	private static void checkMinMax() {
		if (minX > person.x) {
			minX = person.x;
		}
		if (minY > person.y) {
			minY = person.y;
		}
		if (maxX < person.x) {
			maxX = person.x;
		}
		if (maxY < person.y) {
			maxY = person.y;
		}
	}
}
