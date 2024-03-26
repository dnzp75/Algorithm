import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
            if (i < D) graph.get(i).add(new int[]{i + 1, 1}); // 고속도로의 각 지점을 연결
        }

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            if (end <= D) graph.get(start).add(new int[]{end, distance}); // 지름길 추가
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 시작 지점

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0}); // 시작점

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (dist[currentNode] < currentDistance) continue;

            for (int[] next : graph.get(currentNode)) {
                int nextNode = next[0];
                int nextDistance = currentDistance + next[1];

                if (nextDistance < dist[nextNode]) {
                    dist[nextNode] = nextDistance;
                    pq.add(new int[]{nextNode, nextDistance});
                }
            }
        }

        System.out.println(dist[D]);
    }
}
