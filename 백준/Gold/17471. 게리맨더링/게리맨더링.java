import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, answer;
    static boolean[] v;
    static Node[] nodes;
    static int[] now;
    static List<int[]> A;
    static List<int[]> B;

    static class Node {
        int num;
        int[] linked;

        Node(int num) {
            this.num = num;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", linked=" + Arrays.toString(linked) +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        init();
//        printNode();
        run();
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void init() throws Exception {
        A = new ArrayList<>();
        B = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            nodes[i].linked = new int[size];
            for (int j = 0; j < size; j++) {
                nodes[i].linked[j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void run() {
        // 선거구 2 구역으로 나누는 경우의 수 뽑기
        for (int i = 1; i < n; i++) {
            v = new boolean[n + 1];
            now = new int[i];
            recur(0, i);
        }

        // 연결되어있는지 확인
        for (int i = 0; i < A.size(); i++) {
//            System.out.println("A" + Arrays.toString(A.get(i)));
//            System.out.println("B" + Arrays.toString(B.get(i)));
            if (checkLinked(A.get(i)) && checkLinked(B.get(i))) {
                findAnswer(A.get(i), B.get(i));
            }
        }
    }

    private static void findAnswer(int[] dataA, int[] dataB) {
        int aScore = 0;
        int bScore = 0;
        for (int output : dataA) {
            aScore += nodes[output].num;
        }
        for (int output : dataB) {
            bScore += nodes[output].num;
        }
//        System.out.println("now A : " + aScore);
//        System.out.println("now B : " + bScore);

        if (Math.abs(aScore - bScore) < answer) {
            answer = Math.abs(aScore - bScore);
        }
    }

    private static boolean checkLinked(int[] linkedData) {
        int linkedSize = linkedData.length;
        boolean[] nowV = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();

        q.add(linkedData[0]);
        nowV[linkedData[0]] = true;

        Set<Integer> set = new HashSet<>();
        for (int output : linkedData) {
            set.add(output);
        }
//        List<int[]> listData = Arrays.asList(linkedData);
        int nowCnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
//            System.out.println(cur);
            nowCnt++;

            for (int output : nodes[cur].linked) {
                if (set.contains(output) && !nowV[output]) {
                    nowV[output] = true;
                    q.add(output);
                }
            }
        }
//        System.out.println("해당 경우 연결된 선거구 수 " + nowCnt);
        if (nowCnt == linkedSize) {
//            System.out.println("성공");
            return true;
        } else {
//            System.out.println("실패");
            return false;
        }
    }

    private static void recur(int depth, int size) {
        if (depth == size) {
//            System.out.println("now Case");
//            System.out.println(Arrays.toString(now));
            A.add(now.clone());
            int[] caseB = new int[n - size];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!v[i]) {
                    caseB[cnt] = i;
                    cnt++;
                }
            }
//            System.out.println(Arrays.toString(caseB));
            B.add(caseB.clone());
            return;
        }
        if (depth == 0) {
            for (int i = 1; i <= n; i++) {
                v[i] = true;
                now[depth] = i;
                recur(depth + 1, size);
                v[i] = false;
            }
        } else {
            for (int i = now[depth - 1] + 1; i <= n; i++) {
                v[i] = true;
                now[depth] = i;
                recur(depth + 1, size);
                v[i] = false;
            }
        }
    }

    private static void printNode() {
        for (Node output : nodes) {
            if (output == null) {
                continue;
            }
            System.out.println(output.toString());
        }
    }

}
