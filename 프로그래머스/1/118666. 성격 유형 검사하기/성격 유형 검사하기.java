import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 결과를 저장할 변수
        String answer = "";
        
        // 각 성격 유형의 점수를 저장할 HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        // 각 질문에 대해 점수 계산
        for (int i = 0; i < choices.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                // 비동의 선택지인 경우
                map.put(disagreeType, map.get(disagreeType) + (4 - choice));
            } else if (choice > 4) {
                // 동의 선택지인 경우
                map.put(agreeType, map.get(agreeType) + (choice - 4));
            }
        }
        
        // 각 지표에 대해 결과 계산
        answer += map.get('R') >= map.get('T') ? "R" : "T";
        answer += map.get('C') >= map.get('F') ? "C" : "F";
        answer += map.get('J') >= map.get('M') ? "J" : "M";
        answer += map.get('A') >= map.get('N') ? "A" : "N";
        
        return answer;
    }
}
