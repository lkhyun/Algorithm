import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[][] table;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            table = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    table[i][j] = sc.nextInt();
                }
            }
            int[] numbers = new int[N];
            for (int i = 0; i < N/2; i++) {
                numbers[i] = 0;
            }
            for (int i = N/2; i < N; i++) {
                numbers[i] = 1;
            }
            int min = Integer.MAX_VALUE;
            do {
                int[] A = new int[N/2];
                int aIdx = 0;
                int[] B = new int[N/2];
                int bIdx = 0;
                for (int i = 0; i < N; i++) {
                    if(numbers[i]==0){
                        A[aIdx++] = i;
                    }else{
                        B[bIdx++] = i;
                    }
                }
                int totalA = 0;
                int totalB = 0;
                for(int i=0;i<N/2-1;i++){
                    for (int j = i+1; j < N/2; j++) {
                        totalA += table[A[i]][A[j]] + table[A[j]][A[i]];
                        totalB += table[B[i]][B[j]] + table[B[j]][B[i]];
                    }
                }
                min = Math.min(min,Math.abs(totalA-totalB));
            } while (np(numbers));
            System.out.printf("#%d %d\n",t,min);
        }

    }

    static boolean np(int[] numbers){
        int i = N-1;
        while(i>0 && numbers[i-1]>=numbers[i]) --i;
        if(i==0) return false;

        int j = N-1;
        while(numbers[i-1]>=numbers[j]) --j;
        swap(i-1,j,numbers);

        int k = N-1;
        while(i<k) swap(i++, k--, numbers);

        return true;
    }
    static void swap(int i, int j, int[] numbers){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

