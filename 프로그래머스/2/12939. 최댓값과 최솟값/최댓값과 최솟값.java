import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] a = s.split(" ");

        int[] c = new int[a.length];

        
        for( int i=0; i<a.length; i++){
            c[i] = Integer.parseInt(a[i]);
        }
        
        Arrays.sort(c);        
        
                
        answer = c[0] + " " + c[c.length-1];
        
        return answer;
    }
}