import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] height = new int[N];
        for(int i=0;i<N;i++){
            height[i] = sc.nextInt();
        }
        Arrays.sort(height);
        for(int i:height){
            if(L>=i) L++;
        }
        System.out.println(L);
    }
}