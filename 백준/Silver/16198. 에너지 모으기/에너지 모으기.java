import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, max;
    static int[] data;
    static int[] choice;
    static boolean[] v;
    static List<int[]> choices = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        choice = new int[n - 2];
        v = new boolean[n];
        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void run() {
        makeChoice(0);

        for(int[] output : choices){
//            System.out.println(Arrays.toString(output));
            max = Math.max(cal(output), max);
        }
        System.out.print(max);
    }

    private static void makeChoice(int depth) {
        if (depth == n - 2) {
            choices.add(choice.clone());
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (!v[i]) {
                v[i] = true;
                choice[depth] = i;
                makeChoice(depth + 1);
                v[i] = false;
            }
        }
    }
    private static int cal(int[] curChoice){
        int result = 0;
        boolean[] curV = new boolean[n];

        for(int i = 0 ; i < n-2;i++){
            int left = findLeft(curChoice[i], curV);
            int right = findRight(curChoice[i], curV);
//            System.out.println(left + " : " + right + " result : " + (data[left] * data[right]));
            result += data[left] * data[right];
            curV[curChoice[i]] = true;
        }

        return result;
    }
    private static int findLeft(int curIdx, boolean[] curV){
        int idx = curIdx - 1;
        while(true){
            if(curV[idx]){
                idx--;
            }else{

                break;
            }
        }

        return idx;
    }
    private static int findRight(int curIdx, boolean[] curV){
        int idx = curIdx + 1;
        while(true){
            if(curV[idx]){
                idx++;
            }else{

                break;
            }
        }
        return idx;
    }
}
