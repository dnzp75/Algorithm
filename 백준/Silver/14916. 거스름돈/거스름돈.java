import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i= n / 5; i>=0; i--) {
			int remain = n - (i*5);
			if(remain %2 ==0){
				int j = remain/2;
				System.out.println(i+j);
				return;
			}
		}
		
		System.out.println(-1);
	}
}