import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] liq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liq);
		
		int check = Integer.MAX_VALUE;
		
		int answer1 = 0; // 출력할 때 특성값이 더 작은 용액
		int answer2 = 0; // 특성값이 더 큰 용액
		
			int low = 0;
			int high = N-1;
			
			while(low<high) {
				int sum = liq[low]+liq[high];
				
				if(Math.abs(sum)<check) { //0에 가까우니 절댓값으로 바꿔서 비교
					check = Math.abs(sum);
					answer1 = liq[low];
					answer2 = liq[high];
				}
				
				if(sum < 0) {
					low++; //음수 값이 크니까 왼쪽 포인터를 옮겨준다
				}
				else {
					high--; //양수 값이 크니까 오른쪽 포인터를 옮겨준다.
				}				
			}
		
		System.out.println(answer1+" "+answer2);
	}
}