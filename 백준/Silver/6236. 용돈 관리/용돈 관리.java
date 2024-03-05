import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] expenses = new int[N];
        int maxExpense = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            expenses[i] = Integer.parseInt(br.readLine());
            maxExpense = Math.max(maxExpense, expenses[i]);
            sum += expenses[i];
        }

        int low = maxExpense, high = sum;
        int answer = sum; // 최악의 경우 모든 금액을 한 번에 인출하는 경우

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(expenses, mid, M)) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int[] expenses, int k, int m) {
        int count = 1;
        int currentSum = 0;

        for (int expense : expenses) {
            if (currentSum + expense > k) {
                count++;
                currentSum = 0;
            }
            currentSum += expense;
        }

        return count <= m;
    }
}
