import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(Math.abs(a), Math.abs(b));
                if (cmp != 0) return cmp;         // 절댓값 작은 순
                return Integer.compare(a, b);      // 절댓값 같으면 실제 값 작은 순(음수 먼저)
            }
        );

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(x); // 음수면 음수 그대로 저장
            } else {
                if (pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
