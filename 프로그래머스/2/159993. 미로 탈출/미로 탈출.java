import java.util.*;

class Solution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private int n, m;

    private class Moving {
        int x, y, depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        Moving start = null;
        Moving end = null;
        Moving lever = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);

                if (ch == 'S') {
                    start = new Moving(i, j, 0);
                } else if (ch == 'L') {
                    lever = new Moving(i, j, 0);
                } else if (ch == 'E') {
                    end = new Moving(i, j, 0);
                }
            }
        }

        int toLever = bfs(maps, start, lever);
        if (toLever == -1) return -1;

        int toExit = bfs(maps, lever, end);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, Moving start, Moving goal) {
        Queue<Moving> qu = new LinkedList<>();
        qu.add(start);
        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;

        while (!qu.isEmpty()) {
            Moving cn = qu.poll();

            if (cn.x == goal.x && cn.y == goal.y) {
                return cn.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cn.x + dx[i];
                int ny = cn.y + dy[i];

                if (inRange(nx, ny) && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    qu.add(new Moving(nx, ny, cn.depth + 1));
                }
            }
        }

        return -1;
    }

    private boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
