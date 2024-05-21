import java.io.*;
import java.util.*;

public class Main {
    static boolean chk;
    static int min=Integer.MAX_VALUE, original;
    static void swap(char[] arr,int idx1, int idx2) {
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    static void permutation(char[] arr, int st, int len) {
        if(st == len-1) {
            int sum=0;
            for(int i=0;i<len;i++){
                sum+=Math.pow(10,(len-i-1))*(arr[i]-'0');
            }
            if(original<sum){
                if(min>sum){
                    min = sum;
                    chk = true;
                }
            }
            return;
        }
        for(int i=st;i<len;i++) {
            swap(arr,i,st);
            permutation(arr,st+1,len);
            swap(arr,i,st);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String X = br.readLine();
        char[] arr = X.toCharArray();
        original = Integer.parseInt(X);
        permutation(arr,0,arr.length);
        if(chk)
            System.out.println(min);
        else
            System.out.println(0);
    }
}