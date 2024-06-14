class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(!(Character.isLowerCase(c) || Character.isDigit(c) || c=='-' || c=='_' || c=='.')){
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i)=='.' && sb.charAt(i-1)=='.'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        if(sb.length() > 0 && sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        
        if(sb.length() >0 && sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.length() == 0){
            sb.append('a');
        }
        
        if(sb.length()>=16){
            sb.setLength(15);
            if(sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
        while(sb.length()<3){
            sb.append(sb.charAt(sb.length()-1));
        }
        
        return sb.toString();
    }
}