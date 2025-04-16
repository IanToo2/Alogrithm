import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String strA =br.readLine();
        String strB =br.readLine();

        char[] a = strA.toCharArray();
        char[] b = strB.toCharArray();

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char cur : a) {
            mapA.put(cur, mapA.getOrDefault(cur, 0) + 1);
        }
        for (char cur : b) {
            mapB.put(cur, mapB.getOrDefault(cur, 0) + 1);
        }

        if (a[0] != b[0] || a[n - 1] != b[n - 1]) {
            System.out.println("NO");
            return;
        }

        for (Map.Entry<Character, Integer> cur : mapA.entrySet()) {
            char key = cur.getKey();
            int val = cur.getValue();
            if (mapB.get(key) != val) {
                System.out.println("NO");
                return;
            }
        }

        if(!compare(strA, strB)){
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    private static boolean compare(String strA, String strB) {
        return strA.replaceAll("[aeiou]", "").equals(strB.replaceAll("[aeiou]", ""));
    }
}
