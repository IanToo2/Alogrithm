import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    //
    static int T, gearCnt;
    static int[] dict = {-1, 1};
    static Gear[] Gears;

    static class Gear {
        int num;
        List<Integer> type = new ArrayList<>();
    }


    public static void main(String[] args) throws Exception {
        init();
        System.out.print(sb);
    }

    public static void init() throws Exception {
//        T = Integer.parseInt(br.readLine());
//        for (int TNum = 1; TNum <= T; TNum++) {
//            int order = Integer.parseInt(br.readLine());
//
//            // 톱니바퀴 입력
//            Gears = new Gear[4];
//
//            for (int i = 0; i < 4; i++) {
//                Gears[i] = new Gear();
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < 8; j++) {
//                    Gears[i].type.add(Integer.parseInt(st.nextToken()));
//                }
//            }
//
//            // 돌리기 시작
//            for (int i = 0; i < order; i++) {
//                st = new StringTokenizer(br.readLine());
//                int gearNum = Integer.parseInt(st.nextToken());
//                int turnDict = Integer.parseInt(st.nextToken());
//                run(gearNum - 1, turnDict);
//            }
//
//            int answer = getScore();
//            sb.append("#").append(TNum).append(" ").append(answer).append("\n");
//
//        }
        gearCnt = Integer.parseInt(br.readLine());
        // 톱니바퀴 입력
        Gears = new Gear[gearCnt];

        for (int i = 0; i < gearCnt; i++) {
            Gears[i] = new Gear();
//            st = new StringTokenizer(br.readLine());
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                Gears[i].type.add(input[j] - '0');
//                Gears[i].type.add(Integer.parseInt(st.nextToken()));
            }
        }
        int order = Integer.parseInt(br.readLine());
        // 돌리기 시작
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int turnDict = Integer.parseInt(st.nextToken());
            run(gearNum - 1, turnDict);
        }
        System.out.print(getScore());
    }

    public static void run(int gearNum, int turnDict) {
        // turnDict == 1 시계 방향
        // turnDict == -1 반시계 방향
        Deque<int[]> q = new ArrayDeque<>();
        List<Integer> moveLeft = new ArrayList<>();
        List<Integer> moveRight = new ArrayList<>();
        boolean[] v = new boolean[gearCnt];
        boolean check;

        if (turnDict == 1) {
            moveRight.add(gearNum);
        } else {
            moveLeft.add(gearNum);
        }

        v[gearNum] = true;
        q.add(new int[]{gearNum, turnDict});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nowNum = cur[0];
            int nowDict = cur[1];

            for (int i = 0; i < 2; i++) {
                int nCur = nowNum + dict[i];

                if (nCur < 0 || nCur >= gearCnt || v[nCur]) continue;
                v[nCur] = true;
//                System.out.println(nCur+"번 검사");
                /// 왼쪽 검사
                if (i == 0 && Gears[nowNum].type.get(6) != Gears[nCur].type.get(2)) {
//                    System.out.println("좌측 성공");
                    if (nowDict == -1) {
                        moveRight.add(nCur);
                    } else {
                        moveLeft.add(nCur);
                    }
                }
                // 오른쪽 검사
                else if (i == 1 && Gears[nowNum].type.get(2) != Gears[nCur].type.get(6)) {
//                    System.out.println("우측 성공");
                    if (nowDict == -1) {
                        moveRight.add(nCur);
                    } else {
                        moveLeft.add(nCur);
                    }
                } else {
                    continue;
                }
                q.add(new int[]{nCur, nowDict * -1});

            }
        }
//        System.out.println("move Gear");
//        System.out.println(moveLeft);
//        System.out.println(moveRight);

        // 시계 방향 움직임
        for (int output : moveRight) {
            int keep = Gears[output].type.get(7);
            Gears[output].type.remove(7);
            Gears[output].type.add(0, keep);
        }
        // 반시계 방향 움직임
        for (int output : moveLeft) {
            int keep = Gears[output].type.get(0);
            Gears[output].type.remove(0);
            Gears[output].type.add(7, keep);
        }
//        print();
    }

    public static int getScore() {
        int score = 0;
        for (int i = 0; i < gearCnt; i++) {
            if (Gears[i].type.get(0) == 1) {
//                score += (int) Math.pow(2, i);
                score += 1;

            }
        }
        return score;
    }

    public static void print() {
        for (Gear output : Gears) {
            System.out.println(output.type);
        }
    }
}
