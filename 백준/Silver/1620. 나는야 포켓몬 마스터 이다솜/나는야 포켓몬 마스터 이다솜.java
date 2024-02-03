import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    // 포켓몬의 개수
    static int N;
    // 문제의 개수
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        // 1 <= N,M <= 100,000
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> data = new HashMap<>();
        String [] names = new String[N];
//        String[] name = new String[N];
        // 포켓몬 데이터 입력
        for (int i = 0; i < N; i++) {
            // 첫글자만 대문자 나머지 소문자, 일부는 마지막도 대문자
            // 2 <= 포켓몬 이름 길이 <= 20
//            name[i] = br.readLine();
            String name = br.readLine();
            data.put(name, i+1);
            names[i] = name;
        }
        // 질문 시작
        for (int i = 0; i < M; i++) {
            // 정답 출력
            // 이름 -> 번호
            // 번호 -> 이름
            String input = br.readLine();
            // 이름이 들어온 경우
            if (Character.isUpperCase(input.charAt(0))) {
//                sb.append(Arrays.asList(name).indexOf(input) + 1).append("\n");
                sb.append(data.get(input)).append("\n");
            }
            // 번호가 들어온 경우
            else {
                sb.append(names[Integer.parseInt(input) -1]).append("\n");
//                sb.append(name[Integer.parseInt(input) - 1]).append("\n");

            }
        }
        System.out.println(sb);
    }
}
