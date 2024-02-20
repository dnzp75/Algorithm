
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; // 전체 사람의 수
    static ArrayList<Integer>[] family; // 가족 관계를 나타내는 그래프
    static boolean[] visited; // 방문 여부를 체크하는 배열
    static int[] distance; // 시작점으로부터의 거리(촌수)를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 부분에서 예외 상황을 고려하여 처리
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        family = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            // 양방향으로 관계를 추가
            family[parent].add(child);
            family[child].add(parent);
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];

        bfs(person1, person2);

        // 결과 출력
        if (distance[person2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[person2]);
        }
    }

    // BFS
    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == end) break; // 목표 인물을 찾으면 종료

            for (int next : family[current]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1; // 촌수 업데이트
                }
            }
        }
    }
}
