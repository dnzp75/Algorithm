class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<signs.length; i++){
            if(signs[i] == false){
                absolutes[i] = absolutes[i] - (absolutes[i]*2);
                answer +=  absolutes[i];
            } else if(signs[i] == true){
                answer += absolutes[i];
            }
        }
        
        return answer;
    }
}