import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 각 인물의 이름과 그리움 점수를 저장하는 해시맵 생성
        HashMap<String, Integer> score = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            score.put(name[i], yearning[i]);
        }
        
        // 각 사진의 추억 점수를 저장할 배열 초기화
        int[] answer = new int[photo.length];
        
        // 각 사진에 대해 추억 점수 계산
        for(int i = 0; i < photo.length; i++){
            int photoScore = 0;
            for(int j = 0; j < photo[i].length; j++){
                String person = photo[i][j];
                if(score.containsKey(person)) {
                    photoScore += score.get(person);
                }
            }
            answer[i] = photoScore;
        }
        
        return answer;
    }
}
