import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String document = br.readLine();
            String word = br.readLine();

            int count = 0;
            for (int i = 0; i <= document.length() - word.length();) {  // i = 0,1,2,3,4,5
                if (document.startsWith(word, i)) {
                    count++;
                    i += word.length(); // 단어의 길이만큼 인덱스 이동
                } else {
                    i++;
                }
            }

            System.out.println(count);
        }
    }