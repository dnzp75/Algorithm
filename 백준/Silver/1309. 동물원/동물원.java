import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int MOD = 9901;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //dp[0][0] 크기 1의 칸에서 0번째 행에 공백일 때 경우의 수
        //dp[0][1] 크기 1의 칸에서 0번째 행에 왼쪽에 사자가 있을 떄 경우의 수
        //dp[0][2] 크기 1의 칸에서 0번째 행에 오른쪽에 사자가 있을 떄 경우의 수
        dp = new long[N][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        System.out.println((dp[N-1][0] +dp[N-1][1] + dp[N-1][2]) % MOD);
    }
}