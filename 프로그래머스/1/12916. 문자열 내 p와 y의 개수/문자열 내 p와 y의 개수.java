class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int a=0;
        int b=0;
        for( int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if( ch == 'p' || ch == 'P'){
                a++;
            } else if( ch == 'y' || ch=='Y'){
                b++;
            }
        }
        // 'p'와 'y'의 개수를 비교
        if (a == b) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}