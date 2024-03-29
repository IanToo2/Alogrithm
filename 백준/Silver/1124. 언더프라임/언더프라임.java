import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    public static void run() {
        int answer = 0;
        for (int i = a; i <= b; i++) {
//            System.out.println(i + "에 대해서 진행");
            int len = factorization(i);
//            System.out.println(len);
            if (len == 1 || (len != 2 && len % 2 == 0)) {
                continue;
            }
            if (isPrime(len)) {
                answer++;
            }
        }
//        System.out.println("total cnt : " + answer);
        System.out.println(answer);
    }

    public static int factorization(int value) {
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        // 소인수 분해 시작
        for (int i = 2; i <= value; i++) {
//            System.out.println("value : " + value);
//            System.out.println("i : " + i);
            if (value == 1) {
                break;
            }
            while (value % i == 0) {
//                result.add(i);
                cnt++;
                value = value / i;
            }
        }
//        System.out.println("result : " + result);
//        System.out.println("result len : " + result.size());

//        return result.size();
        return cnt;
    }


    public static boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
