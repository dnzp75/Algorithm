import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String a = Long.toString(n);
        String[] arr = a.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr){
            sb.append(s);
        }
        
        
        return Long.parseLong(sb.toString());
    }
}