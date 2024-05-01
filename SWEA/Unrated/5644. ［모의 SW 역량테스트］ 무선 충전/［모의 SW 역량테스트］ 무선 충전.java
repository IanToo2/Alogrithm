import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int m, a;
    static int totalA;
    static int totalB;
    static int[] A;
    static int[] B;
    static int[] moveA;
    static int[] moveB;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Charger[] charger;
    static List<int[]>[][] map;

    static class Charger {
        int x;
        int y;
        int c;
        int p;

        Charger(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            init();
            run();
//            printMap();
            sb.append("#").append(i).append(" ").append(totalA + totalB).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        initMap();
        // Init Person
        A = new int[]{0, 0};
        B = new int[]{9, 9};
        totalA = 0;
        totalB = 0;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        moveA = new int[m];
        moveB = new int[m];
        // Init Charger Cnt
        a = Integer.parseInt(st.nextToken());
        charger = new Charger[a];
        // Input Person A
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moveA[i] = Integer.parseInt(st.nextToken());
        }
        // Input Person B
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moveB[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println("Input Charger Data");
        // Input Charger Data
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            // Set charger data in map
            setCharger(x, y, c, p, i + 1);
            charger[i] = new Charger(x, y, c, p);
        }


    }

    private static void run() {
        sortMap();
        movePerson();
    }

    private static void movePerson() {
        // Move cnt == m
        useCharger();
        for (int i = 0; i < m; i++) {
//            System.out.println();
//            System.out.println("Time : " + (i + 1));
            int dictA = moveA[i] - 1;
            move(dictA, A);
            int dictB = moveB[i] - 1;
            move(dictB, B);
            useCharger();
//            System.out.println("A : " + Arrays.toString(A) + " cost : " + totalA);
//            System.out.println("B : " + Arrays.toString(B) + " cost : " + totalB);
        }
    }

    private static void move(int dict, int[] person) {
        if (dict == -1) {
            return;
        }
        person[0] += dx[dict];
        person[1] += dy[dict];
    }

    private static void useCharger() {
        int chargerA = -1;
        int chargerB = -1;

        if (!map[A[0]][A[1]].isEmpty()) {
            chargerA = map[A[0]][A[1]].get(0)[0];
        }
        if (!map[B[0]][B[1]].isEmpty()) {
            chargerB = map[B[0]][B[1]].get(0)[0];
        }
//        System.out.println("A가 사용할 충전기 번호 : " + chargerA);
//        System.out.println("B가 사용할 충전기 번호 : " + chargerB);
        // 같은 충전기 범위에 있는경우
        if (chargerA != -1 && chargerB != -1) {
            if (chargerA == chargerB) {
//                System.out.print("A가 사용가능한 번호 : ");
//                for (int[] output : map[A[0]][A[1]]) {
//                    System.out.print(output[0] + " ");
//                }
//                System.out.println();
//                System.out.print("B가 사용가능한 번호 : ");
//                for (int[] output : map[B[0]][B[1]]) {
//                    System.out.print(output[0] + " ");
//                }
//                System.out.println();
//                System.out.println("겹치는 경우 발생");
                // 둘다 충전기를 1개씩만 겹치는 경우
                if (map[A[0]][A[1]].size() == 1 && map[B[0]][B[1]].size() == 1) {
//                    System.out.println("반반 나눠 가지기 : " + charger[chargerA - 1].p / 2);
                    totalA += charger[chargerA - 1].p / 2;
                    totalB += charger[chargerB - 1].p / 2;
                }
                //
                else if (map[A[0]][A[1]].size() == 1 && map[B[0]][B[1]].size() > 1) {

                    int second = map[B[0]][B[1]].get(1)[1];

//                    System.out.println("B가 다른거 사용 : " + second);
                    totalA += charger[chargerA - 1].p;
                    totalB += second;

                } else if (map[A[0]][A[1]].size() > 1 && map[B[0]][B[1]].size() == 1) {

                    int second = map[A[0]][A[1]].get(1)[1];

//                    System.out.println("A가 다른거 사용 : " + second);
                    totalA += second;
                    totalB += charger[chargerB - 1].p;

                } else {
                    int nowValue = charger[chargerB - 1].p;
                    int secondA = map[A[0]][A[1]].get(1)[1];
                    int secondB = map[B[0]][B[1]].get(1)[1];

                    if(secondA > secondB){
                        totalA += secondA;
                        totalB += nowValue;
                    }else{
                        totalA += nowValue;
                        totalB += secondB;
                    }
                }
            } else {
                totalA += charger[chargerA - 1].p;
                totalB += charger[chargerB - 1].p;
            }
        } else if (chargerA != -1) {
            totalA += charger[chargerA - 1].p;
        } else if (chargerB != -1) {
            totalB += charger[chargerB - 1].p;
        } else {
            return;
        }

    }

    private static void setCharger(int x, int y, int c, int p, int idx) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[10][10];
        v[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            map[cur[0]][cur[1]].add(new int[]{idx, p});

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10 || v[nx][ny] || cur[2] == c) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }

    private static void initMap() {
        // Default size 10
        map = new List[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
    }

    private static void sortMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j].sort((o1, o2) -> {
                    return o2[1] - o1[1];
                });
            }
        }
    }

    private static void printMap() {
        System.out.println("Map");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " , " + j);
                for (int[] output : map[i][j]) {
                    System.out.print(Arrays.toString(output) + " , ");
                }
                System.out.println();
            }
        }
    }
}
