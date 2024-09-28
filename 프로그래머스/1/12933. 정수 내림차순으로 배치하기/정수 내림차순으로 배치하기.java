import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s);
        
        String str = "";
        for(int i= s.length-1; i>=0; i--){
            str+=s[i];
        }
        
        answer = Long.parseLong(str);
        
        return answer;
    }
}