class Solution {
    public int[] solution(long n) {
        
        String[] arr = String.valueOf(n).split("");
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            answer[i] = Integer.parseInt(arr[arr.length-1-i]);
        }
        
        // String[] 배열 내에 있는 값 뒤집기
        // String[] -> int[]형으로 변환
        return answer;
    }
}