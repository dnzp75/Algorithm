class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
            for(int j=2; j<n; j++){
                if(n%j == 1){
                    answer = j;
                    break;
                }
            }
        
        return answer;
    }
}