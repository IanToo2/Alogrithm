import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // --------------------------------------- //


    public static void main(String[] args) throws Exception {
        init();

    }

    public static void init() throws Exception {
        int n = Integer.parseInt(br.readLine());
        System.out.println((n * (n + 1) * (n + 2)) / 2);
    }


}