import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
	public static long N, M, K = 0;
	public static long answer = 0;
	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Long.parseLong(st.nextToken());
    	
    	binarySearch(0, N);
    	
    	System.out.println(answer);
    }
    
    public static void binarySearch(long start, long end) {
    	long left = 0;
    	long right = end;
    	
    	while(left <= right) {
    		long middle = (left + right) / 2;
    		if( Math.pow( middle, 2) >= N) {
    			answer = middle;
    			right = middle - 1;
    		}
    		else if(Math.pow(middle, 2) < N){
    			left = middle + 1;
    		}
    	}
    	
    }
    
}