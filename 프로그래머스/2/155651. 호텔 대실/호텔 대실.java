import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] bookTime = new int[book_time.length][2];

        for(int i=0; i<book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));

            end+=10;
            if (end % 100 >= 60) end+=40;

            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }

        Arrays.sort(bookTime,(a1,a2) -> a1[0] - a2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1],b[1]);
            }
        });

        for(int[] book : bookTime){

            if (pq.isEmpty()) {
                pq.add(book);
            } else{
                int[] tmp = pq.peek();
                int start = tmp[0];
                int end = tmp[1];

                if(book[0]>=end){
                    pq.poll();
                }
                pq.add(book);
            }
        }
        answer = pq.size();
        return answer;
    }
}