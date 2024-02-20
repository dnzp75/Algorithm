import java.util.Scanner;

public class Main {
    private static int[][] field;
    private static boolean[][] visited;
    private static int M, N, K;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            field = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                field[x][y] = 1;
            }

            int count = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if(field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
