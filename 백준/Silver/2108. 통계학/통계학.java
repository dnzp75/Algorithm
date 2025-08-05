import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		int[] count = new int[8001]; // -4000 ~ 4000 → +4000 shift

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			nums[i] = x;
			sum += x;

			count[x + 4000]++;
			max = Math.max(max, x);
			min = Math.min(min, x);
		}

		// 1. 산술평균
		System.out.println(Math.round((double) sum / n));

		// 2. 중앙값
		Arrays.sort(nums);
		System.out.println(nums[n / 2]);

		// 3. 최빈값
		int maxFreq = 0;
		for (int i = 0; i < 8001; i++) {
			maxFreq = Math.max(maxFreq, count[i]);
		}

		List<Integer> modeList = new ArrayList<>();
		for (int i = 0; i < 8001; i++) {
			if (count[i] == maxFreq) {
				modeList.add(i - 4000); // 다시 원래 값으로 변환
			}
		}

		if (modeList.size() > 1) {
			Collections.sort(modeList);
			System.out.println(modeList.get(1)); // 두 번째로 작은 값
		} else {
			System.out.println(modeList.get(0));
		}

		// 4. 범위
		System.out.println(max - min);
	}
}