class Solution {
    public int solution(String s) {
        int answer = 0;
        int count=0;
        int countNotX=0;
        char x = s.charAt(0);
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == x){
                count++;
            } else {
                countNotX++;
            }
            
            if(count == countNotX){
                answer++;
                
                if(i+1<s.length()){
                    x=s.charAt(i+1);
                }
                
                count =0;
                countNotX=0;
            }
             
        }
        
        if(count != 0 || countNotX != 0){
            answer++;
        }
        return answer;
    }
}