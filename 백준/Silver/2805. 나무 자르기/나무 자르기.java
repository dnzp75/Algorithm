
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ags) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이
        long[] trees = new long[N]; // 나무의 높이를 저장할 배열

        st = new StringTokenizer(br.readLine()); // 나무 높이를 입력받기 위해 StringTokenizer 재사용
        long max = 0;
        for(int i = 0; i < N; i++){
            trees[i] = Long.parseLong(st.nextToken()); // 나무의 높이를 배열에 저장
            if(max < trees[i]){
                max = trees[i]; // 가장 높은 나무의 높이 찾기
            }
        }

        long start = 0; // 시작점을 0으로 설정
        long end = max; // 최대 높이
        long H = 0; // 절단기 높이의 최댓값을 찾기 위한 변수

        while(start <= end){
            long mid = (start + end) / 2;
            long count = 0; // 자른 나무의 총 길이

            for(int i = 0; i < N; i++){
                if(trees[i] > mid){
                    count += trees[i] - mid; // 절단기 높이보다 높은 나무만 자르고 그 길이를 합산
                }
            }
            if(count >= M){
                H = mid; // 필요한 길이 이상으로 나무를 얻을 수 있으면, 절단기 높이 업데이트
                start = mid + 1; // 더 높은 절단기 높이 탐색
            }
            else{
                end = mid - 1; // 나무 길이가 부족하면, 절단기 높이를 낮춤
            }
        }

        System.out.println(H); // 최대 절단기 높이 출력
    }
}
