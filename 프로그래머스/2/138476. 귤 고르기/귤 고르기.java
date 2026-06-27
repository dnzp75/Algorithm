import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1 );
            }
        }
        
        // for(int i=0; i<map.size(); i++){
        //     list.add(map.get(i+1));
        // }
        for (int count : map.values()) {
             list.add(count);
            }   
        
        
        list.sort(Collections.reverseOrder());
        
        
        int sum=0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
            answer++;
            
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }
}