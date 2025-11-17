import java.io.*;
import java.util.*;

public class Main {
    //그래프 방향 간선 저장 리스트
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());
        int[][] answer = new int[N][N];
        //그래프 방향 간선 저장
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1)
                    graph.get(i).add(j);
            }
        }
        //각 정점에서 BFS 탐색 진행
        for(int i=0;i<N;i++)
            bfs(i, answer, N);

        //각 정점 방문 확인 배열의 형태 BufferdWriter 저장
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++)
                bw.write(answer[i][j] + " " );
            bw.newLine();
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //BFS 탐색 진행하여 방문 확인하는 함수
    public static void bfs(int start, int[][] answer, int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];	//방문 확인 배열
        q.add(start);		//기준 정점 Queue 저장
        //탐색 진행
        while(!q.isEmpty()) {
            int cur = q.poll();
            //간선 탐색!
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next]= true;
                    answer[start][next] = 1;
                    q.add(next);
                }
            }
        }
    }
}