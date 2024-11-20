class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] s = String.valueOf(x).split("");
        
        int[] a = new int[s.length];
        
        for(int i=0; i<s.length; i++){
            a[i] = Integer.parseInt(s[i]);
        }
        
        int sum=0;
        
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }
        
        if(x%sum ==0){
            answer = true;
        }
        else {
            answer = false;
        }
        return answer;
    }
}