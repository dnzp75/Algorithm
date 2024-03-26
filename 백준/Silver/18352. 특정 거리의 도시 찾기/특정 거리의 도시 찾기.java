
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int n;
    static int[] table;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        table = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(table, (int) 1e9);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        table[x] = 0;

        dijkstra(x);

        int cnt = 0;
        for (int i = 1; i < table.length; i++) {
            if (table[i] == k) {
                System.out.println(i);
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.offer(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = table[now] + 1;
                if (cost < table[graph.get(now).get(j)]) {
                    table[graph.get(now).get(j)] = cost;
                    que.offer(graph.get(now).get(j));
                }
            }
        }
    }
}
