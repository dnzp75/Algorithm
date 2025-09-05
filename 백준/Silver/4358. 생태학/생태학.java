import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> count = new HashMap<>();
        long total = 0; // 1,000,000까지 가능하니 넉넉히 long

        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() == 0) continue; // 빈 줄 방어(문제 입력엔 거의 없음)
            count.put(line, count.getOrDefault(line, 0) + 1);
            total++;
        }

        // 사전순 정렬
        List<String> species = new ArrayList<>(count.keySet());
        Collections.sort(species);

        StringBuilder sb = new StringBuilder();
        for (String name : species) {
            double percent = count.get(name) * 100.0 / total;
            // Locale.US를 주면 소수점 구분자가 항상 '.'이 됨
            sb.append(name).append(' ').append(String.format(Locale.US, "%.4f", percent)).append('\n');
        }
        System.out.print(sb.toString());
    }
}
