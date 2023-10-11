class Solution {
	public int solution(int n, int m, int[] section) {
        int roller = section[0]; // 색칠 시작 지점
        int cnt = 1; // 무조건 한 번은 칠한다
        for(int i = 1; i < section.length; i++) {
        	
        	// 지금 칠할 곳이 이전에 칠했던 범위에 포함되어 있는지 판별
            if(roller + m - 1 < section[i]) { // 시작 지점도 칠해야 되서 roller + m에 - 1해줌
                cnt++;
                roller = section[i];
            }
        }
        return cnt;
    }
}