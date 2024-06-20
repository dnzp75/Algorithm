import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            hashmap.put(players[i], i);
        }
        
        for(String player : callings){
            int playerRanking = hashmap.get(player);
            
            String frontPlayer = players[playerRanking-1];
            
            players[playerRanking-1] = player;
            players[playerRanking] = frontPlayer;
            
            hashmap.put(player, playerRanking-1);
            hashmap.put(frontPlayer, playerRanking);
            
        }
        return players;
    }
}