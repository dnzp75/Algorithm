import java.util.Scanner;

// 계단 오르기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 각 계단 점수
        int[] stair = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        // 해당 계단 위치까지의 최고 점수
        int[] score = new int[n + 2];
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        for (int i = 3; i <= n; i++) {
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }

        System.out.println(score[n]);
    }
}