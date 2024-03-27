import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    //
    // 트럭의 수
    static int n;
    // 다리의 길이
    static int w;
    // 다리의 최대 하중
    static int l;
    static int roadW = 0;
    static Deque<Integer> trucks = new ArrayDeque<>();
    static Deque<int[]> road = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

    }

    public static void run() {

        int answer = 0;
        // 트럭 추가로 올리기
        while (!road.isEmpty() || !trucks.isEmpty()) {
            answer++;
            // 1. Road에 더 못 올리는 상황
            // 1-1 올라갈 Truck이 더 없는 경우
            // 1-2 무게가 한계인 상황
            // 1-3 자리가 더 없는 경우
            moveTruck();
            if (roadW >= l || road.size() == w) {
                continue;
            }
            // 2. Road에 더 올릴 수 있는 상황
            if (!trucks.isEmpty()) {
                int nextTruck = trucks.poll();
                if (roadW + nextTruck > l) {
                    trucks.addFirst(nextTruck);
                    continue;
                }
                roadW += nextTruck;
                road.add(new int[]{nextTruck, w});
            }

//            System.out.println("trucks");
//            System.out.println(trucks);
//            System.out.println(answer);
//            System.out.println("road");
//            for (int[] output : road) {
//                System.out.print("(" + output[0] + "," + output[1] + ")");
//            }
//            System.out.println();
//            System.out.println("now Road Weight = " + roadW);
//            System.out.println();
//            answer++;


        }
        System.out.print(answer);
    }

    public static void moveTruck() {
        int roadCnt = road.size();

        while (roadCnt-- > 0) {
            int[] now = road.poll();
            int nowW = now[0];
            int nowCnt = now[1] - 1;

            if (nowCnt == 0) {
                roadW -= nowW;
                continue;
            }
            road.add(new int[]{nowW, nowCnt});
        }
    }
}
