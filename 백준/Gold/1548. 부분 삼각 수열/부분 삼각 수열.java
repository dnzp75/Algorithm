import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 2;
        Arrays.sort(arr);
        if(n < 3){
            ans = n;
        }else{
            for (int i = 0; i < n - 1; i++) {
                for (int j = n-1; j >= i; j--) {
                    if(i+1 == j){
                        break;
                    }
                    if(arr[i] + arr[i+1] > arr[j]){
                        ans = Math.max(ans, j - i + 1);
                        break;
                    }
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}