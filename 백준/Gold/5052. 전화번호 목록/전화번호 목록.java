import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Map<Character, Node> chiledNode = new HashMap<>();
		boolean leaf;
	}

	static class Trie {

		Node rootNode = new Node();

		void insert(String str) {
			Node node = this.rootNode;

			for (int i = 0; i < str.length(); i++) {
				node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			node.leaf = true;
		}

		boolean search(String str) {
			Node node = this.rootNode;

			for (int i = 0; i < str.length(); i++) {
				node = node.chiledNode.getOrDefault(str.charAt(i), null);
				if (node == null) {
					return false;
				}
			}
			return node.leaf;
		}

		int levelOrder() {
			int cnt = 0;
			Deque<Node> q = new ArrayDeque<>();
			q.add(rootNode);

			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.chiledNode.isEmpty()) {
					cnt++;
					continue;
				}
				for (Map.Entry<Character, Node> entry : cur.chiledNode.entrySet()) {
					q.add(entry.getValue());
				}
			}
			return cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			Trie trie = new Trie();

			int cnt = Integer.parseInt(br.readLine());
			List<String> data = new ArrayList<>();
			for (int j = 0; j < cnt; j++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				trie.insert(str);
				data.add(str);
			}

			if (trie.levelOrder() == cnt) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}

		}
		System.out.print(sb);
	}
}
