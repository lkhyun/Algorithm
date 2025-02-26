import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] mountain = new int[N+1];
            for (int i = 1; i <= N; i++) {
                mountain[i] = sc.nextInt();
            }
            int total = 0;
            for (int i = 1; i <= N;i++) {
                int j = i;
                while(j<N && mountain[j]<mountain[j+1]) j++;
                if(j==N || j==i) continue;
                
                int k = j;
                int sum = 0;
                while(k<N && mountain[k] > mountain[k+1]){
                    sum++;
                    k++;
                }
                total += sum*(j-i);
                i = k-1;
            }
            System.out.println("#"+t+" "+total);
        }
    }
}