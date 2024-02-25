import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        char [] data = br.readLine().toCharArray();
        for(char value : data){
            if(Character.isUpperCase(value)){
                sb.append(Character.toLowerCase(value));
            }else{
                sb.append(Character.toUpperCase(value));
            }
        }
        System.out.println(sb);
    }
}