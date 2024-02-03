import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException, NumberFormatException {

		int bitmask = 0;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("all"))
				bitmask = (1 << 21) - 1;
			else if (order.equals("empty"))
				bitmask = 0;
			else {
				int num = Integer.parseInt(st.nextToken());
				if (order.equals("add"))
					bitmask |= (1 << num);
				else if (order.equals("remove"))
					bitmask &= ~(1 << num);
				else if (order.equals("check"))
					sb.append((bitmask & (1 << num)) != 0 ? 1 : 0).append("\n");
				else if (order.equals("toggle"))
					bitmask ^= (1 << num);
			}
		}
		System.out.println(sb);

	}
}