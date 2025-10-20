import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> answer=new ArrayList<>();
        answer=generatePermutationwithRepetition(N,M);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.size();i++){
            int[] now = answer.get(i);
            for(int j=0;j<M;j++){
                sb.append(now[j]);
                if(j!=M-1)sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static List<int[]> generatePermutationwithRepetition(int N,int M){
        List<int[]> result = new ArrayList<>();
        int[] cur = new int[M];
        dfs(0,N,M,cur,result);
        return result;
    }
    private static void dfs(int depth, int N, int M, int[] cur, List<int[]> result){
        if(depth==M){
            result.add(Arrays.copyOf(cur,M));
            return;
        }
        for(int i=1;i<=N;i++){
            cur[depth]=i;
            dfs(depth+1,N,M,cur,result);
        }
    }
}