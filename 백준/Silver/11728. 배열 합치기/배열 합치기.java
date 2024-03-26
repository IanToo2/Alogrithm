import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //
    static int x, y;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
        System.out.print(sb);
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < y; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
    }

    public static void run() {
        int idxa = 0;
        int idxb = 0;

        boolean check = true;

        while (true) {
//            System.out.println("idxa, idxb = " + idxa + "," + idxb);
            if (idxa == x || idxb == y) {
                break;
            }
            if (a.get(idxa) < b.get(idxb)) {
                check = true;
            } else {
                check = false;
            }

            if (check) {
                if (idxa == x) {
                    sb.append(b.get(idxb)).append(" ");
                    idxb++;
                } else {
                    sb.append(a.get(idxa)).append(" ");
                    idxa++;
                }
            } else {
                if (idxb == y) {
                    sb.append(a.get(idxa)).append(" ");
                    idxa++;
                } else {
                    sb.append(b.get(idxb)).append(" ");
                    idxb++;
                }
            }
        }

//        System.out.println("idxa, idxb = " + idxa + "," + idxb);

        if (idxa == x) {
            for (int i = idxb; i < y; i++) {
                sb.append(b.get(i)).append(" ");
            }
        } else {
            for (int i = idxa; i < x; i++) {
                sb.append(a.get(i)).append(" ");
            }
        }

    }
}