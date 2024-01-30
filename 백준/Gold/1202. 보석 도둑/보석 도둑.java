import java.io.*;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int value, weight;

        public Jewel(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }

    static int N, K;
    static long answer = 0;
    static int[] bag;
    static Jewel[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(V, M);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewels);

        PriorityQueue<Integer> pq = new PriorityQueue<>(N, Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j].weight <= bag[i]) {
                pq.add(jewels[j++].value);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
