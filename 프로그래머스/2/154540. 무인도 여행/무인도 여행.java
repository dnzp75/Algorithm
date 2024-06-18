import java.util.*;

class Solution {

    private final int[] dx = {-1,1,0,0};
    private final int[] dy = {0,0,-1,1};
    private int n,m;
    private class Position{
        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] maps) {

        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                char ch = maps[i].charAt(j);

                if(ch != 'X' && !visited[i][j]){
                    int days = bfs(maps,visited, new Position(i,j));
                    answer.add(days);
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(String[] maps, boolean[][] visited, Position start){
    Queue<Position> queue = new LinkedList<>();
    queue.add(start);
    visited[start.x][start.y] = true;
    int totalDays = 0;
    
    while(!queue.isEmpty()){
        Position pos = queue.poll();
        totalDays += maps[pos.x].charAt(pos.y) - '0';
        
        for(int i=0; i<4; i++){
            int nx = pos.x + dx[i];
            int ny = pos.y + dy[i];
            
            if(inRange(nx,ny) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                visited[nx][ny] = true;
                queue.add(new Position(nx,ny));
            }
        }
    }
    return totalDays;
    
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}