import java.util.*;

public class Main {
    static List<Integer>[] network; // 네트워크 연결 정보를 저장할 리스트 배열
    static boolean[] visited; // 각 컴퓨터 방문 여부를 저장할 배열
    static int infectedCount = 0; // 감염된 컴퓨터의 수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 컴퓨터의 수
        int m = scanner.nextInt(); // 연결된 컴퓨터 쌍의 수

        network = new ArrayList[n + 1]; // 1번부터 시작하므로 n+1 크기로 초기화
        visited = new boolean[n + 1]; // 방문 여부 배열 초기화

        for (int i = 1; i <= n; i++) {
            network[i] = new ArrayList<>();
        }

        // 네트워크 연결 정보 입력
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            // 양방향 연결
            network[a].add(b);
            network[b].add(a);
        }

        // 1번 컴퓨터부터 DFS 시작
        dfs(1);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터의 수 출력
        System.out.println(infectedCount - 1);
    }

    // DFS 메소드
    static void dfs(int start) {
        if (visited[start]) {
            return; // 이미 방문한 컴퓨터라면 더 이상 탐색하지 않음
        }
        visited[start] = true; // 방문 표시
        infectedCount++; // 감염된 컴퓨터 수 증가

        // 현재 컴퓨터와 연결된 모든 컴퓨터에 대해 DFS 탐색
        for (int next : network[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
