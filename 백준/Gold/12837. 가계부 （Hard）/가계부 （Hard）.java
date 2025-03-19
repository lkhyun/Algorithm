import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int Q;
    static long[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new long[N*4];
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int arg1 = Integer.parseInt(st.nextToken());
            long arg2 = Integer.parseInt(st.nextToken());
            if(option == 1){ //수정
                update(1,1,N,arg1,arg2);
            }else if(option == 2){//구간 출력
                bw.write(query(1,1,N,arg1,(int)arg2)+"\n");
            }
        }
        bw.close();
    }
    public static void update(int cur, int start, int end, int idx, long diff){
        if(idx<start || idx>end) return;
        tree[cur] += diff;
        if(start != end){
            update(cur*2,start,(start+end)/2,idx,diff);
            update(cur*2 + 1,(start+end)/2 + 1,end,idx,diff);
        }
    }
    public static long query(int cur, int start, int end, int left, int right){
        if(left>end || right<start) return 0;
        if(left<=start && right>=end) return tree[cur];

        long l = query(cur*2,start,(start+end)/2,left,right);
        long r = query(cur*2+1,(start+end)/2 + 1, end,left,right);
        return l+r;
    }
}