class Solution {
    public String solution(String code) {
        int mode = 0;
        String rec = "";

        for(int idx=0; idx<code.length(); idx++){
          if( code.charAt(idx) == '1' ){
              mode = mode == 0 ? 1 : 0 ;
          }
          if( code.charAt(idx) == '1' ) continue;
            
          if(mode == 0 && idx%2 == 0){
             rec += code.charAt(idx); 
          }
        
           if(mode == 1 && idx%2 !=0 ){               
             rec += code.charAt(idx);
          }            
            //System.out.println("rec : "+rec);           
        }
  
        if (rec == null || rec.trim().isEmpty()){
            rec = "EMPTY";
        }
        
        return rec;
    }
}