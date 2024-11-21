class Solution {
    public String solution(String[] seoul) {

        int i=0;
        
        for(String s : seoul){
            if(s.equals("Kim")){
                break;
            }
            i++;
        }
        return "김서방은 " + i + "에 있다";
    }
}