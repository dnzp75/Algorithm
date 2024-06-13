import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for(String data : X.split("")){
            int cur = Integer.parseInt(data);
            xMap.put(cur, xMap.getOrDefault(cur,0)+1);
        }
        
        for(String data : Y.split("")){
            int cur = Integer.parseInt(data);
            yMap.put(cur, yMap.getOrDefault(cur,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=9; i>=0; i--){
            if(xMap.containsKey(i) && yMap.containsKey(i)){
                int cnt = Math.min(xMap.get(i), yMap.get(i));
                for(int j=0; j<cnt; j++){
                    sb.append(i);
                }
            }
        }
        
        if(sb.toString().startsWith("0")){
            return "0";
        } else if(sb.toString().equals("")){
            return "-1";
        }
        return sb.toString();
    }
}