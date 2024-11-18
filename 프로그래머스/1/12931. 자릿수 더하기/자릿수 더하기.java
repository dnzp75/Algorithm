import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;


        String[] arr = String.valueOf(n).split("");
        
        for(String a : arr){
            answer += Integer.parseInt(a);
        }

        return answer;
    }
}

// 여기서 배운 것
// 1. int형 -> String 형 변환
// 2. String 문자열 분리하는 방법