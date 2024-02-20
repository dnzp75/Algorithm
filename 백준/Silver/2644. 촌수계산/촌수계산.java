import java.util.*;

public class Main {
    static int n; // 전체 사람의 수
    static ArrayList<Integer>[] family; // 가족 관계를 나타내는 그래프
    static boolean[] visited; // 방문 여부를 체크하는 배열
    static int answer = -1; // 촌수 결과, 관계가 없으면 -1을 유지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int person1 = sc.nextInt();
        int person2 = sc.nextInt();
        int m = sc.nextInt();
        
        family = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            family[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            // 양방향으로 관계를 추가
            family[parent].add(child);
            family[child].add(parent);
        }
        
        visited = new boolean[n+1];
        
        dfs(person1, person2, 0);
        
        // 결과 출력
        System.out.println(answer);
    }

    static void dfs(int current, int target, int depth) {
        if(current == target) {
            answer = depth;
            return;
        }
        
        visited[current] = true;
        
        for(int next : family[current]) {
            if(!visited[next]) {
                dfs(next, target, depth + 1);
            }
        }
    }
}