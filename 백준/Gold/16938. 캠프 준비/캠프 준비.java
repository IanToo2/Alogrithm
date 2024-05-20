
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    private static int comb(int[] input, int depth, int n, int l , int r, int x, boolean[] visited){
        if(depth == n){
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int i = 0 ; i < n ; i++){
                if(visited[i]){
                    sum += input[i];
                    min = Math.min(min,input[i]);
                    max = Math.max(max,input[i]);
                }
            }
            if(max - min < x){
                return 0;
            }
            if(sum >= l && sum <= r){
                return 1;
            }
            return 0;
        }
        int result = 0;
        visited[depth] = true;
        result += comb(input,depth+1,n,l,r,x,visited);
        visited[depth] = false;
        result += comb(input,depth+1,n,l,r,x,visited);
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int l = stoi.apply(st.nextToken());
        int r = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        boolean[] visited = new boolean[n];
        System.out.println(comb(input,0,n,l,r,x,visited));
    }
}