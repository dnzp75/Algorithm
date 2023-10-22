class Solution {
    public int solution(int a, int b) {
        
        String answer = Integer.toString(a)+Integer.toString(b);
        int answer1 = Integer.valueOf(answer);
        int answer2 = 2*a*b;
        
        if(answer1>=answer2){
            return answer1;
        } else {
            return answer2;
        }
        
    }
    
}