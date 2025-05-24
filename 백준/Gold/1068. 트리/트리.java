import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] tree;
	static int deleteNode, leafCount =0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n];
		
		for(int i=0; i<n; i++){
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for(int i=0; i<n; i++){
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1){
				root = i;
			} else {
				tree[parent].add(i);
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		
		if(deleteNode == root){
			System.out.println(0);
		} else {
			dfs(root);
			System.out.println(leafCount);
		}
		
	}
	
	static void dfs(int current){
		if(current == deleteNode) return;
		
		if(tree[current].isEmpty() || tree[current].size() ==1 && tree[current].contains(deleteNode)){
			leafCount++;
			return;
		}
		
		for(int child : tree[current]){
			if(child != deleteNode){
				dfs(child);
			}
		}
	}
}