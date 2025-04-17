import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0 ; i< n ; i++){
            String str = new StringTokenizer(br.readLine()).nextToken();
            if(Integer.parseInt(str.substring(2)) > 90){
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
