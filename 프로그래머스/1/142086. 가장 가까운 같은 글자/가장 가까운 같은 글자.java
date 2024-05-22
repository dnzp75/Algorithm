import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        
        Map<Character, Integer> lastPosition = new HashMap<>();
        
        for( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(lastPosition.containsKey(c)){
                answer[i] = i- lastPosition.get(c);
            }
            
            lastPosition.put(c,i);
        }
        return answer;
    }
}