import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int n = elements.length;

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;

                for (int k = 0; k < length; k++) {
                    int index = (start + k) % n;
                    sum += elements[index];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}