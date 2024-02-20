import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<Integer>[] network; // 네트워크 연결 정보를 저장할 리스트 배열
    static boolean[] visited; // 각 컴퓨터 방문 여부를 저장할 배열
    static int count = 0; // 감염된 컴퓨터의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int connection = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        network = new ArrayList[computer + 1]; // 1번부터 시작하므로 n+1 크기로 초기화
        visited = new boolean[computer + 1]; // 방문 여부 배열 초기화

        for (int i = 1; i <= computer; i++) {
            network[i] = new ArrayList<>();
        }

        // 네트워크 연결 정보 입력
        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 연결
            network[a].add(b);
            network[b].add(a);
        }

        // 1번 컴퓨터부터 DFS 시작
        dfs(1);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터의 수 출력
        System.out.println(count - 1);
    }

    // DFS 메소드
    static void dfs(int start) {
        if (visited[start]) {
            return; // 이미 방문한 컴퓨터라면 더 이상 탐색하지 않음
        }
        visited[start] = true; // 방문 표시
        count++; // 감염된 컴퓨터 수 증가

        // 현재 컴퓨터와 연결된 모든 컴퓨터에 대해 DFS 탐색
				for (int next : network[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}