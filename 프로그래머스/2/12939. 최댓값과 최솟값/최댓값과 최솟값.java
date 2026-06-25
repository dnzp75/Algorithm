import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");        
        int [] arr2 = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            arr2[i] = Integer.parseInt(arr[i]);
        }
        
        int min = arr2[0];
        int max = arr2[0];
        
        for(int i=1; i<arr2.length; i++){
            if(min > arr2[i]){
                min = arr2[i];
            }
            
            if( max < arr2[i]) {
                max = arr2[i];
            }
        }
        
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}