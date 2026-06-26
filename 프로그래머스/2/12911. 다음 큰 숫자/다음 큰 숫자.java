import java.util.*;

class Solution {

    public int solution(int n) {
        int answer = 0;
        boolean flag = false;
        int a = n+1;
        int oneCount = ejinbab(n);
        
        while(flag == false){            
            int oneCount2 = ejinbab(a);
            if(oneCount == oneCount2){
                flag = true;
            } else{
                a = a+1;
            }
        }
        
        answer = a;
        return answer;
    }
    
    public int ejinbab(int a){        
        List<Integer> list = new ArrayList<>();
        
        while( a > 0){
            int q = a % 2;    
            list.add(q);
            a = a / 2;
        }
        
        int oneNumber =0;
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == 1){
                oneNumber++;
            }
        }        
        
        return oneNumber;

        
    }
}