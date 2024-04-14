
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  static class Candidate {
    int student;
    int count;
    int time;  // 게시된 시간 (최근성을 비교하기 위함)

    public Candidate(int student, int time) {
      this.student = student;
      this.count = 1;  // 추천 받을 때마다 이 생성자 호출
      this.time = time;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 사진틀 개수
    int totalRecommendations = Integer.parseInt(br.readLine());  // 총 추천 횟수
    String[] recommendations = br.readLine().split(" ");

    List<Candidate> frames = new ArrayList<>();  // 사진틀 관리 리스트

    for (int i = 0; i < totalRecommendations; i++) {
      int student = Integer.parseInt(recommendations[i]);
      boolean isPosted = false;

      for (Candidate c : frames) {
        if (c.student == student) {
          c.count++;  // 이미 게시된 학생이면 추천 수만 증가
          isPosted = true;
          break;
        }
      }

      if (!isPosted) {
        if (frames.size() < N) {
          frames.add(new Candidate(student, i));  // 비어 있는 사진틀에 추가
        } else {
          // 사진틀이 모두 찼다면 가장 추천 횟수가 적고, 게시된 지 가장 오래된 사진 삭제
          Collections.sort(frames, new Comparator<Candidate>() {
            public int compare(Candidate c1, Candidate c2) {
              if (c1.count == c2.count) {
                return c1.time - c2.time;
              }
              return c1.count - c2.count;
            }
          });
          frames.remove(0);
          frames.add(new Candidate(student, i));  // 새로운 학생을 추가
        }
      }
    }

    Collections.sort(frames, Comparator.comparingInt(c -> c.student));  // 학생 번호 순으로 정렬
    StringBuilder sb = new StringBuilder();
    for (Candidate c : frames) {
      sb.append(c.student).append(" ");
    }
    System.out.println(sb.toString().trim());  // 최종 후보 출력
    br.close();
  }
}
