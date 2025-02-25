import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[] input;
    static int[] operator;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            input = new int[N];
            operator = new int[N-1];
            int idx = 0;
            for(int i=0;i<4;i++){
                int temp = sc.nextInt();
                for(int j=0;j<temp;j++){
                    operator[idx++] = i;
                }
            }
            for (int i = 0; i < N; i++) {
                input[i] = sc.nextInt();
            }

            Arrays.sort(operator);  
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            do {
                int cur=input[0];
                for(int i=0;i<N-1;i++){
                    if(operator[i]==0){
                        cur += input[i+1];
                    }else if(operator[i]==1){
                        cur -= input[i+1];
                    }else if(operator[i]==2){
                        cur *= input[i+1];
                    }else if(operator[i]==3){
                        cur /= input[i+1];
                    }
                }
                max = Math.max(max,cur);
                min = Math.min(min,cur);
            } while (np());
            System.out.printf("#%d %d\n",t,Math.abs(min - max));
        }

    }

    static boolean np(){
        int i = N-2;
        while(i>0 && operator[i-1]>=operator[i]) --i;
        if(i==0) return false;

        int j = N-2;
        while(operator[i-1]>=operator[j]) --j;
        swap(i-1,j);

        int k = N-2;
        while(i<k) swap(i++, k--);

        return true;
    }
    static void swap(int i, int j){
        int temp = operator[i];
        operator[i] = operator[j];
        operator[j] = temp;
    }
}