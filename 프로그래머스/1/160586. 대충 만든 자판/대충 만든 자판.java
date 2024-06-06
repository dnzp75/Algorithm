import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                if(!hashmap.containsKey(c) || hashmap.get(c) > j+1){
                     hashmap.put( c, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int score = 0;
            boolean canType = true;
            for(char c : targets[i].toCharArray()){
                if(hashmap.containsKey(c)){
                    score += hashmap.get(c);
                } else {
                    canType = false;
                    break;
                }
            }
            
            if(!canType){
                answer[i] = -1;
            } else {
                answer[i] = score;
            }
        }
        return answer;
    }
}