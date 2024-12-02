class Solution {
    public String solution(String s) {        
        String[] st = s.trim().split("\\s+"); // 공백 기준으로 나누기;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String stt : st){
            int value = Integer.parseInt(stt);
            if (value < min) min = value;
            if (value > max) max = value;            
        }
        
        return min + " " + max;
    }
}