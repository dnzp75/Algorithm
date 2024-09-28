class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int arr[] = new int[s.length()];
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            arr[k++] = s.charAt(i) - '0';
        }
        return arr;
    }
}