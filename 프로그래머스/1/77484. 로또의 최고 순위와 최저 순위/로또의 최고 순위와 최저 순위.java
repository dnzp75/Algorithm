class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero=0;
        int number =0;
        
        for(int l : lottos){
            if(l ==0) zero++;
            else {
                for(int w : win_nums){
                    if(w == l) {
                        number++;
                        break;
                    }
                }
            }
        }
        
        int min = number;
        int max = number+zero;
        
        int[] answer = {Math.min(7-max,6), Math.min(7-min,6) };
        

        return answer;
    }
}