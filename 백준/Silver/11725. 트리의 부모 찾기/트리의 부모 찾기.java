import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


	private static List<Integer>[] list;
	// private static List<List<Integer>> list;

	private static int[] parents;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];

		for(int i=0; i<=n; i++){
			list[i] = new ArrayList<>();
		}


		for(int i=0; i<n-1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);


			// [0]
			// [1] 4,  6
			// [2]
			// [3] 5
			// [4] 2,7
			// [5]
			// [6] 3
			// [7]
		}

		parents = new int[n+1];
		visited = new boolean[n+1];

		findParent(1);

		for(int i=2; i<=n; i++){
			System.out.println(parents[i]);
		}


	}

	private static void findParent(int currentNode){
		visited[currentNode] = true;

		for(int adjNode : list[currentNode]){
			if(!visited[adjNode]){
				parents[adjNode] = currentNode;
				findParent(adjNode);
			}

		}
	}
}