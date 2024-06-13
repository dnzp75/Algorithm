import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers) {
        
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++){
            list.add(numbers[i]); // [1,2,3,4,6,7,8,0]	
            }
        for(int i=0; i<10; i++){
            if(list.contains(i)){
                continue;
            }
            answer+= i;
        }
        return answer;
    }
}