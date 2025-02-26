import java.util.*;
public class Solution {
    static int N;
    static int B;
    static int min;
    static int[] member;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            B = sc.nextInt();
            member = new int[N];

            for(int i = 0;i<N;i++){
                member[i] = sc.nextInt();                
            }
            min = Integer.MAX_VALUE;
            combination(0, 0);
            System.out.println("#"+t+" "+(min-B));
        }
    }
    public static void combination(int sum, int start){
        if(sum >= B){
            min = Math.min(min,sum);
            return;
        }

        for(int i=start;i<N;i++){
            combination(sum+member[i], i+1);
        }
    }
}