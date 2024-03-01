import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Box implements Comparable<Box> {
        int start, end, count;

        public Box(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        @Override
        public int compareTo(Box o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();
        Box[] boxes = new Box[M];
        for (int i = 0; i < M; i++) {
            boxes[i] = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(boxes);
        int[] capacity = new int[N+1];
        Arrays.fill(capacity, C);
        int result = 0;

        for (Box box : boxes) {
            int minCapacity = Integer.MAX_VALUE;
            for (int i = box.start; i < box.end; i++) {
                minCapacity = Math.min(minCapacity, capacity[i]);
            }

            int deliverable = Math.min(minCapacity, box.count);
            for (int i = box.start; i < box.end; i++) {
                capacity[i] -= deliverable;
            }
            result += deliverable;
        }

        System.out.println(result);
    }
}
