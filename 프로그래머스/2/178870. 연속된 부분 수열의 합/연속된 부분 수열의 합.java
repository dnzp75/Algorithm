class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        
        while(true){
            if(sum>=k){
                sum -= sequence[left++];
            }
        
                else if(right >= sequence.length) break;
                 else if(sum<k){
                     sum += sequence[right++];
            
        }
        
        if(sum==k){
            if(right-left < len){
                answer[0] = left;
                answer[1] = right-1;
                len = right-left;
            }
        }
    }
        
        
        
        return answer;
    }
}