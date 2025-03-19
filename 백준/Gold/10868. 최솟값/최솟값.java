import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N*4];
        tree = new long[N*4];
        
        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(query(1,1,N,left,right)+"\n");
        }
        bw.close();
    }
    public static void init(int cur, int start, int end){
        if(start == end){
            tree[cur] = arr[start];
            return;
        }

        init(cur*2,start,(start+end)/2);
        init(cur*2 + 1, (start+end)/2 + 1, end);
        tree[cur] = Math.min(tree[cur*2],tree[cur*2 + 1]);
    }
    public static long query(int cur, int start, int end, int left, int right){
        if(left>end || right<start) return Long.MAX_VALUE;
        if(left<=start && right>=end) return tree[cur];

        long leftMin = query(cur*2,start,(start+end)/2,left,right);
        long rightMin = query(cur*2+1,(start+end)/2 + 1, end,left,right);
        return Math.min(leftMin,rightMin);
    }
}