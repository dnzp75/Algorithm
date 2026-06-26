import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int x;
        int y;

        List<Integer> list = new ArrayList<>();

        for (int i = brown + yellow; i >= 1; i--) {
            if ((brown + yellow) % i == 0) {
                list.add((brown + yellow) / i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            x = list.get(i);
            y = (brown + yellow) / x;

            if ((x - 2) * (y - 2) == yellow) {
                return new int[]{y, x};
            }
        }

        return new int[]{};   // 반드시 있어야 함
    }
}