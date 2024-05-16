import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[D];
        dp[0] = 1;
        dp[1] = 1;

        // DP를 사용하여 피보나치 수열의 계수를 계산
        for (int i = 2; i < D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // A와 B를 찾기 위한 반복문
        boolean found = false;
        int A = 1;
        while (!found) {
            if ((K - dp[D - 3] * A) % dp[D - 2] == 0) {
                int B = (K - dp[D - 3] * A) / dp[D - 2];
                System.out.println(A);
                System.out.println(B);
                found = true;
            }
            A++;
        }
    }
}
