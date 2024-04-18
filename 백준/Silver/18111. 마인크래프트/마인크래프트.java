import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] heightCount = new int[257];  // 높이별 카운트 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                heightCount[height]++;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int targetHeight = 0; targetHeight <= 256; targetHeight++) {
            int removeBlocks = 0;
            int addBlocks = 0;

            for (int h = 0; h <= 256; h++) {
                if (h < targetHeight) {
                    addBlocks += (targetHeight - h) * heightCount[h];
                } else if (h > targetHeight) {
                    removeBlocks += (h - targetHeight) * heightCount[h];
                }
            }

            if (removeBlocks + B >= addBlocks) {  // 충분한 블록이 있는지 확인
                int time = 2 * removeBlocks + addBlocks;
                if (time < minTime || (time == minTime && targetHeight > resultHeight)) {
                    minTime = time;
                    resultHeight = targetHeight;
                }
            }
        }

        System.out.println(minTime + " " + resultHeight);
    }
}
