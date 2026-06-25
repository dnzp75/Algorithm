class Solution {
    boolean solution(String s) {
        boolean answer = true;

        
        String[] arr = s.split("");
        
        int cnt =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("(")){
                cnt++;
            } else {
                cnt--;
            }
            
            if(cnt<0) {
                answer = false;
                return answer;
            }
        }
        
        if( cnt == 0){
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}