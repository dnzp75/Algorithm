import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단의 개수 입력

        // 각 계단 점수 입력
        int[] stair = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // 해당 계단 위치까지의 최고 점수를 계산
        int[] score = new int[n + 2];
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        for (int i = 3; i <= n; i++) {
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }

        System.out.println(score[n]); // 최종 점수 출력
    }
}
