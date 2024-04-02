import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int p, m;
	static List<List<String[]>> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();

			run(l, n);
		}
		for(int i = 0 ; i < data.size();i++) {
			checkRoom(i);
		}
		System.out.println(sb);
//		print();
	}

	public static void run(int level, String name) {
		int size = data.size();
//		System.out.println(size);
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				int nowRange = Integer.parseInt(data.get(i).get(0)[0]);

				if (nowRange - 10 <= level && nowRange + 10 >= level && data.get(i).size() < m) {
					data.get(i).add(new String[] { Integer.toString(level), name });
//					startCheck(i);
					return;
				}
			}
		}
		data.add(new ArrayList<>());
		int addIdx = data.size();
		data.get(addIdx - 1).add(new String[] { Integer.toString(level), name });
	}

	public static void checkRoom(int idx) {
		int nowRoomSize = data.get(idx).size();

//			System.out.println("Started!");
		Collections.sort(data.get(idx), new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			};
		});
		
		if (nowRoomSize == m) {
			sb.append("Started!\n");
		} else {
			sb.append("Waiting!\n");
		}
		
		for (String[] output : data.get(idx)) {
//				System.out.println(output[0] + " " + output[1]);
			sb.append(output[0]).append(" ").append(output[1]).append("\n");

		}

	}

	public static void print() {
		int roomNum = 1;
		for (List<String[]> output : data) {
			System.err.println("roomNum : " + roomNum++);

			for (String[] output2 : output) {
				System.err.println(output2[0] + " , " + output2[1]);
			}
		}
	}

}
