
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] requests = new int[N];
        int maxRequest = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            // 최대 예산 요청을 찾음
            if (requests[i] > maxRequest) {
                maxRequest = requests[i];
            }
        }

        int M = Integer.parseInt(br.readLine());

        // 이진 탐색을 위한 최소값과 최대값 설정
        int low = 0;
        int high = maxRequest;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            // 현재 상한액(mid)를 기준으로 예산 배정 총액 계산
            for (int request : requests) {
                if (request > mid) {
                    sum += mid;
                } else {
                    sum += request;
                }
            }

            // 예산 총액이 M보다 크면 상한액을 줄임
            if (sum > M) {
                high = mid - 1;
            } else {
                // 예산 총액이 M 이하이면 상한액을 늘림 (최적의 상한액 찾기)
                low = mid + 1;
                result = mid; // 현재 상한액을 결과로 저장
            }
        }

        System.out.println(result);
    }
}
