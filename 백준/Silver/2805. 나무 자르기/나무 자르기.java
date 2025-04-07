import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Search(0,1000000000)+"");
        bw.close();
    }
    public static int Search(int left, int right){
        while(left<right){
            int mid = (left+right)/2 + 1;
            long temp = 0;

            for(int i=0;i<N;i++){
                if(trees[i]>mid){
                    temp += trees[i]-mid;
                }
            }
            if(temp<M){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        return left;
    }
}
