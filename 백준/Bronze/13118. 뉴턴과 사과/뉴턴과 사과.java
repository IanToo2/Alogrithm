import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[4];
        
        for (int i = 0; i < 4; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int x =Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        boolean isCrash = false;
        
        for (int i = 0; i < 4; i++) {
            if (data[i] == x) {
                System.out.print(i + 1);
                isCrash = true;
            }
        }

        if (isCrash == false) {
            System.out.print(0);
        }

    }
}