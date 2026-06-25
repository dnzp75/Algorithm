import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int[] C = new int[B.length];
        
        for(int i=0; i<B.length; i++){
            C[i] = B[(B.length-1) - i];
        }
        // System.out.println(Arrays.toString(C));
        
        for(int i=0; i<A.length; i++){
            answer += A[i] * C[i];
        }

        return answer;
    }
}