import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집의 수 N을 입력 받음
        int[][] dp = new int[n][3]; // 각 집을 RGB로 칠하는 누적 최소 비용을 저장할 배열

        // 첫 번째 집의 RGB 비용을 입력 받아 초기화
        String[] costs = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            dp[0][i] = Integer.parseInt(costs[i]);
        }

        // 두 번째 집부터 마지막 집까지 최소 비용 계산
        for (int i = 1; i < n; i++) {
            costs = br.readLine().split(" ");
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(costs[0]); // 빨강으로 칠하는 비용
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(costs[1]); // 초록으로 칠하는 비용
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(costs[2]); // 파랑으로 칠하는 비용
        }

        // 마지막 집을 각각의 색으로 칠했을 때의 최소 비용 중 가장 작은 값 찾기
        int minCost = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);

        System.out.println(minCost); // 결과 출력
    }
}
