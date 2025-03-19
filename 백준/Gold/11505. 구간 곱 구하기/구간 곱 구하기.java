import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static long[] arr;
    static long[] tree;
    final static long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N*4];
        tree = new long[N*4];
        
        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int arg1 = Integer.parseInt(st.nextToken());
            long arg2 = Long.parseLong(st.nextToken());
            if(option == 1){//수정
                arr[arg1] = arg2;
                update(1,1,N,arg1);
            }else if(option == 2){//구간 곱
                bw.write(query(1,1,N,arg1,(int)arg2) + "\n");
            }
        }
        bw.close();
    }
    public static void init(int num, int start, int end){ //초기화하는 거
        if(start==end){
            tree[num] = arr[start];
        }else{
            init(num*2, start, (start+end)/2);
            init(num*2 + 1,(start+end)/2 + 1, end);
            tree[num] = (tree[num*2] * tree[num*2+1]) % MOD;
        }
    }
    public static long query(int num, int start, int end, int left, int right){ 
        if(right<start || left>end){
            return 1;
        }else if(left<=start && right>=end){
            return tree[num];
        }
        long lsum = query(num*2, start, (start+end)/2, left, right);
        long rsum = query(num*2+1, (start+end)/2 + 1, end, left, right);
        return (lsum * rsum) % MOD;
    }
    public static long update(int num, int start, int end, int index){// 수정
        if(start>index || end<index) return tree[num]; //현재 위치가 수정할 곳과 연관이 있는가?

        if(start != end){//현재 위치가 리프노드인가?
            long left = update(num*2, start,(start+end)/2,index);
            long right = update(num*2+1,(start+end)/2 + 1,end,index);
            tree[num] = (left*right) % MOD;
            return tree[num];
        }else{
            tree[num] = arr[start];
            return tree[num];
        }
    }
}