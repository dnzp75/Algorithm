
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent; // 각 노드의 부모 노드를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 초기에 각 노드의 부모는 자기 자신
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v); // 각 간선에 대해 두 정점을 연결(Union)
        }

        int componentCount = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) { // 각 노드에 대해 루트 노드가 자기 자신인 경우, 즉 연결 요소의 대표자인 경우
                componentCount++;
            }
        }

        System.out.println(componentCount); // 연결 요소의 개수 출력
    }

    // Find 함수: 특정 원소가 속한 집합의 루트 노드를 찾음
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    // Union 함수: 두 원소가 속한 집합을 합침
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

}
