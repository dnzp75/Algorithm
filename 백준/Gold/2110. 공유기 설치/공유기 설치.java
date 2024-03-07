// 필요한 Java 기본 라이브러리를 import 합니다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 공백을 기준으로 입력을 분리하기 위해 StringTokenizer를 사용합니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 집의 개수(N)과 공유기의 개수(C)를 입력받습니다.
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        // 각 집의 위치를 저장할 배열을 선언합니다.
        int[] houses = new int[N];
        
        // N개의 집 위치를 입력받아 배열에 저장합니다.
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        
        // 집의 위치를 오름차순으로 정렬합니다.
        Arrays.sort(houses);
        
        // 이진 탐색을 위한 시작점과 끝점을 설정합니다.
        int start = 1; // 가능한 최소 거리
        int end = houses[N - 1] - houses[0]; // 가능한 최대 거리
        int answer = 0; // 최적의 공유기 사이 거리
        
        // 이진 탐색을 수행합니다.
        while (start <= end) {
            int mid = (start + end) / 2; // 중간값을 공유기 사이의 거리로 가정합니다.
            
            // 첫 번째 집에 공유기를 설치하고 시작합니다.
            int installed = 1;
            int lastInstalled = houses[0];
            
            // 다음 집부터 확인하며 공유기를 설치할 수 있는지 검사합니다.
            for (int i = 1; i < N; i++) {
                if (houses[i] - lastInstalled >= mid) {
                    installed++;
                    lastInstalled = houses[i];
                }
            }
            
            // 설치된 공유기 수가 C 이상이면 거리를 늘려볼 여지가 있습니다.
            if (installed >= C) {
                answer = mid; // 답을 업데이트합니다.
                start = mid + 1;
            } else { // 그렇지 않다면 거리를 줄여야 합니다.
                end = mid - 1;
            }
        }
        
        // 최적의 공유기 사이 거리를 출력합니다.
        System.out.println(answer);
    }
}
