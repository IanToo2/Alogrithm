import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, String> data = new HashMap<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 데이터 입력
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            data.put(st.nextToken(), st.nextToken());
        }
        // 데이터 출력
        while (M-- > 0){
            String serachName = br.readLine();
            sb.append(data.get(serachName)).append("\n");
        }
        System.out.println(sb);
    }
}
