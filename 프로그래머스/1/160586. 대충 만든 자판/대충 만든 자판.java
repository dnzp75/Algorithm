import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character,Integer> hashmap = new HashMap<>();
        
        for( int i=0; i<keymap.length; i++){
            String key = keymap[i];
            for(int j=0; j<key.length(); j++){
                char c = key.charAt(j);
                hashmap.put(c,Math.min(hashmap.getOrDefault(c,Integer.MAX_VALUE),j+1));
            }
        }
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            int totalPress = 0;
            boolean canType = true;

            for( char c : target.toCharArray()){
                if(hashmap.containsKey(c)){
                    totalPress += hashmap.get(c);
                } else{
                    canType = false;
                    break;
                }
            }
            answer[i] = canType ? totalPress : -1;
        }
        return answer;
    }
}