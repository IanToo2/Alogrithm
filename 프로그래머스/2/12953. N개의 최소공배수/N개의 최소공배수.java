import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int a = arr[0];
        for(int i = 1 ; i < arr.length;i ++){
            int b = arr[i];
            a = a*b / gcd(a, b);
        }
        return a;
    }
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}