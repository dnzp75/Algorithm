import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int N = Integer.parseInt((br.readLine()));

        // 배열생성  ->  사용자가 입력한 값 만큼 배열 크기 생성 ex) 5입력 시 5개의 인덱스 생성
        int[] arr = new int[N];

        //임의의 예상 등수 저장
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        // 입력한 값 배열의 각 인데스에 젖아하기 위해서는 문자형을 정수형으로 변환
        // arr[0] = 1, arr[1] = 3 , arr[2] = 2, arr[3]=4, arr[4]=3

				Arrays.sort(arr);
				// 배열안에 들어있는 숫자(임의 등수) 값 오름차순으로 정렬

        long ans = 0;
        for (int i = 0; i < N; i++)
            ans = ans + Math.abs(arr[i] - (i + 1));
        System.out.println(ans);
    }
}