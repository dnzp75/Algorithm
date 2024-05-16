
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작점

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) {
                    break; // 도착점이면 탈출
                }

                int jump = board[i][j];
                if (jump == 0) {
                    continue; // 0이면 점프 불가
                }

                if (i + jump < N) {
                    dp[i + jump][j] += dp[i][j]; // 아래로 점프
                }
                if (j + jump < N) {
                    dp[i][j + jump] += dp[i][j]; // 오른쪽으로 점프
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
