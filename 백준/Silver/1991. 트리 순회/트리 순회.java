import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data) {
			this.data = data;
		}
	}

	static Map<Character, Node> nodeMap = new HashMap<>();
	static Node root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			char parent = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);

			nodeMap.putIfAbsent(parent, new Node(parent));
			Node current = nodeMap.get(parent);

			if (i == 0)
				root = current;

			if (left != '.') {
				nodeMap.putIfAbsent(left, new Node(left));
				current.left = nodeMap.get(left);
			}

			if (right != '.') {
				nodeMap.putIfAbsent(right, new Node(right));
				current.right = nodeMap.get(right);
			}
		}

		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);

	}

	static void preorder(Node node) {
		if (node == null) return;
		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) {
		if (node == null) return;
		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	}

	static void postorder(Node node) {
		if (node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	}


}

