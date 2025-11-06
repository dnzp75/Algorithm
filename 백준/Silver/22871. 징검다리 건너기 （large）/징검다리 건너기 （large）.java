import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] stones = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        // 움직이기 위해선 최소 힘이 1은 필요하기 떄문에 start를 1로 설정
        long start = 1;
        // 첫번째 돌에서 바로 마지막 돌로 뛰는 경우를 가장 큰 값으로 설정
        // 이 경우보다 적은 힘으로 갈 수 있는 경우를 찾으면 된다.
        long end = (long)(N - 1) * (long)(1 + Math.abs(stones[N - 1] - stones[0]));
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            boolean[] visited = new boolean[N];
            boolean flag = false;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            visited[0] = true;

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();

                // 방문한 돌이 마직막 돌인 경우 while문 종료
                if (pop == N - 1) {
                    flag = true;
                    break;
                }

                // 현재 있는 돌보다 앞에 있는 돌로 움직일 때 드는 힘이 mid 보다 작은 경우만 stack에 저장
                for (int i = pop + 1; i < N; i++) {
                    long power = (long)(i - pop) * (long)(1 + Math.abs(stones[i] - stones[pop]));
                    if (!visited[i] && power <= mid) {
                        stack.push(i);
                        visited[i] = true;
                    }
                }
            }

            if (flag) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);

    }
}