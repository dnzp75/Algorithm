import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] arr = String.valueOf(n).split("");
        
        Arrays.sort(arr);
        
        
        String str ="";
        
        for(int i=arr.length-1; i>=0; i--){
            str += arr[i];
        }
        return Long.parseLong(str);
    }
}