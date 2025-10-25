import java.util.*;

public class Main {

    static int[][] values;
    public static void sorting(int row, int col){
        int[] arr = new int[4];
        int k=0;
        for(int i=row; i<row+2; i++)
            for(int j=col; j<col+2; j++)
                arr[k++] = values[i][j];
        Arrays.sort(arr);

        values[row/2][col/2] = arr[2];
    }

    public static void pooling(int size){
        if(size < 2){
            System.out.println(values[0][0]);
            return;
        }

        for(int i=0; i<size/2; i++)
            for(int j=0; j<size/2; j++)
                sorting(2*i, 2*j);

        pooling(size/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int size = sc.nextInt();

        values = new int[size][size];

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                values[i][j] = sc.nextInt();

        pooling(size);
    }
}