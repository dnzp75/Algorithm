class Solution {
    public int solution(int a, int b) {
       
        String answerA = String.valueOf(a);
        String answerB = String.valueOf(b);
        
        int answer1 = Integer.valueOf(answerA+answerB);
        int answer2 = Integer.valueOf(answerB+answerA);
        
        if(answer1<answer2){
            answer1=answer2;
        }
        return answer1;  
        }
    
    
    }
