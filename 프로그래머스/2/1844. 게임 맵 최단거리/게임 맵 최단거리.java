import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // 시작점 추가 및 방문 체크
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            // 목적지에 도달했을 경우
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }
            
            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위 내이고, 이동 가능한 위치이며, 방문하지 않은 곳인 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;  // 이동 거리 갱신
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
        // 목적지에 도달할 수 없는 경우
        return -1;
    }
}
