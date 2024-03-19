import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정수 N 입력 받기
        int[] dp = new int[N+1]; // 연산을 사용하는 횟수를 저장할 배열
        
        // 초기값 설정
        dp[1] = 0;
        
        // 작은 수부터 차례대로 최소 연산 횟수 계산
        for(int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i-1] + 1;
            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            // 3으로 나누어 떨어지는 경우
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        
        // 결과 출력
        System.out.println(dp[N]);
    }
}
