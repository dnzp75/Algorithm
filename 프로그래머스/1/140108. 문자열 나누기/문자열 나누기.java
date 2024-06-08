class Solution {
    public int solution(String s) {
        int answer = 0;
        int countX = 0;
        int countNotX = 0;
        char x = s.charAt(0); // 첫 글자를 x로 초기화

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                countX++;
            } else {
                countNotX++;
            }

            if (countX == countNotX) {
                answer++;
                // 카운트 초기화 및 다음 부분 문자열의 첫 글자를 설정
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                countX = 0;
                countNotX = 0;
            }
        }

        // 남은 부분 문자열이 있을 경우
        if (countX != 0 || countNotX != 0) {
            answer++;
        }

        return answer;
    }
}
