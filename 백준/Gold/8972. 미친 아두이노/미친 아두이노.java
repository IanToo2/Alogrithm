import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int r, c;
    static int[] jong = new int[2];
    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[] order;
    static char[][] map;
    static List<int[]> removeList;
    static ArrayList<int[]> aduino; // 해시맵으로 전체 탐색은 연결리스트 속도이기 때문에 느림 (contains 메서드를 활용하지 않으면 배열리스트를 쓰는게 훨씬 의미있음)
    
    public static void main(String[] args) throws Exception {
        init();
        run();
    }
    public static void init() throws Exception {
        aduino = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = input[j];
                // 종수
                if (map[i][j] == 'I') {
                    jong[0] = i;
                    jong[1] = j;
                }
                // 미친 아두이노
                else if (map[i][j] == 'R') {
                    aduino.add(new int[]{i, j});
                }
            }
        }
        order = br.readLine().toCharArray();
    }
    public static void run() {
        for (int i = 0; i < order.length; i++) {
//            System.out.println((i + 1) + "번 시작");
            // 1. 종수의 아두이노 움직이기
            if (!jMove(i)) {
                System.out.print("kraj " + (i + 1));
                return;
            }
            // 2. 미친 아두이노 움직이기
            aduinoMove();
            // 3. 충돌한 미친 아두이노 제거
            aduinoErase();
            //
            if (!setMap()) {
                System.out.print("kraj " + (i + 1));
                return;
            }
        }
        printMap();
        System.out.println(sb);
    }
    public static boolean jMove(int idx) {
        // 미친 아두이노와 만난지 확인

        int nowOrder = (order[idx] - '0') - 1;
        map[jong[0]][jong[1]] = '.';
        jong[0] = jong[0] + dx[nowOrder];
        jong[1] = jong[1] + dy[nowOrder];
        if (map[jong[0]][jong[1]] == 'R') {
            return false;
        }
        map[jong[0]][jong[1]] = 'I';
        return true;
    }
    public static void aduinoMove() {
        Deque<int[]> q = new ArrayDeque<>();
        removeList = new ArrayList<>();
        for (int[] cur : aduino) {
            q.add(cur);
        }
        aduino = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            boolean check = false;
            int nx = cur[0];
            int ny = cur[1];
            // 현재 위치 땅으로
            map[nx][ny] = '.';
            // 미두이노 이동
            if (nx < jong[0]) {
                nx++;
            } else if (nx > jong[0]) {
                nx--;
            }
            if (ny < jong[1]) {
                ny++;
            } else if (ny > jong[1]) {
                ny--;
            }
            // 충돌 확인
            
            //종수와 만났다면...
            if(map[nx][ny] == 'I') {
                aduino.add(new int[]{nx, ny});
            	break;
            }
            for (int[] key : aduino) {
                if (key[0] == nx && key[1] == ny) {
                    if (!removeList.contains(key)) {
                        removeList.add(key);
                    }
//                    int value = e.getValue();
//                    aduino.put(key, value + 1);
                    check = true;
                    break;
                }
            }
            // 없는 경우 값 추가
            if (!check) {
                aduino.add(new int[]{nx, ny});
            }
            

        }
    }
    public static void aduinoErase() {
        for (int[] key : removeList) {
            aduino.remove(key);
        }
//        for (Map.Entry<int[], Integer> e : aduino.entrySet()) {
//            int[] key = e.getKey();
//            int value = e.getValue();
//            System.out.println(Arrays.toString(key));
//            System.out.println(value);
//            if (value != 1) {
//                aduino.remove(key);
//            }
//        }
    }
    public static boolean setMap() {
        for (int[] key : aduino) {
            map[key[0]][key[1]] = 'R';
        }
        if (map[jong[0]][jong[1]] == 'R') {
            return false;
        }
        map[jong[0]][jong[1]] = 'I';
//        System.out.println("Map Data");
        return true;
    }
    public static void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
//                System.out.print(map[i][j]);
            }
            if (i != r - 1) {
                sb.append("\n");
//                System.out.println();
            }
        }
    }
}
