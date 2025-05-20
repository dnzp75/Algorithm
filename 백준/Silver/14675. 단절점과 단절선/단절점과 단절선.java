import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		// 1-2-3-4-5

		// 1 - 2
		// 2 - 1, 3
		// 3 - 2, 4
		// 4 - 3, 5
		// 5 - 4

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if(t==1){
				sb.append(tree[k].size()>1 ? "yes\n" : "no\n");
			} else {
				sb.append("yes\n");
			}
		}

		System.out.println(sb);
	}

}