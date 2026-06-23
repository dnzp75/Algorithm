class Solution {
    public String solution(String s) {
		String answer = "";

		String[] arr = s.split("");

		int a = arr.length;

		if (a % 2 != 0) {
			int b = a/2;
			answer = arr[b];
		} else {
			int b = a/2;
			answer = arr[b-1] + arr[b];
		}

	return answer;

    }
}