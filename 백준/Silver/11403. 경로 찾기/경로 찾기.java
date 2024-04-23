import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 정점의 수 N
        int[][] graph = new int[N][N]; // 인접 행렬
        int[][] result = new int[N][N]; // 결과 행렬

        // 인접 행렬 입력 받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        // BFS로 각 노드에서 도달 가능한 노드 찾기
        for (int start = 0; start < N; start++) {
            boolean[] visited = new boolean[N];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next = 0; next < N; next++) {
                    if (graph[current][next] == 1 && !visited[next]) {
                        visited[next] = true;
                        result[start][next] = 1; // start에서 next로 갈 수 있는 경로가 있음
                        queue.add(next);
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
