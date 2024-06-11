import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0 ;
        
        int start = 1;
        a -= 1;
        b -= 1;
        while(b / start != a / start){
            start*=2;
            answer++;
        }
        
        return answer;
    }
}