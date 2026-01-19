import java.util.*;

class Solution {
    public String solution(String s) {
        String[] a = s.split(" ");
                
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for( String a2 : a){
            int a3 = Integer.parseInt(a2);
            if( min > a3) {
                min = a3;
            }
            if( max < a3){
                max = a3;
            }
        }
        
        return min + " " + max;
    
    }
}