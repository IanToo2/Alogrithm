
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            if (input.equals(".")) {
                break;
            }
            if(checkData(input)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
    private static boolean checkData(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();
                if ((ch == ')' && openBracket != '(') || (ch == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

