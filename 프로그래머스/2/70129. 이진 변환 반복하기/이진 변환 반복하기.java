import java.util.*;

class Solution {
    
    int run, removeZeroNumber=0;
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        
        String[] arr = s.split("");
        int[] a = new int[s.length()];
        
        for(int i=0; i<arr.length; i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                
        removeZeroNumber(a);
        
        // answer = {run, removeZeroNumber} ;

        return new int[] {run, removeZeroNumber};
    }
    
    public void removeZeroNumber(int[] a){
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<a.length; i++){
            if(a[i] == 0){
                removeZeroNumber++;
            } else {
                list.add(a[i]);
            }
        }
        run++;
        
        int removeZeroArterLength = list.size();
        
        if(removeZeroArterLength == 1){
            return;
        }

        int[] t = ejinbab(removeZeroArterLength);
            removeZeroNumber(t);
    }    

    
    
    public int[] ejinbab(int n){
        // 6 -> 이진법 수행
        List<Integer> list2 = new ArrayList<>();
        
        while( n > 0){
            int q = n % 2;
            list2.add(q);
            n = n / 2;         
        }
        
        int[] c = new int[list2.size()];
        
        for(int i=0; i<list2.size(); i++){
            c[i] = list2.get((list2.size()-1)-i);
        }        
        return c;
    }
}