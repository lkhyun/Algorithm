import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static long[] arr;
    static long[] tree;
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
                update(1,1,N,arg1,arg2-arr[arg1]);
                arr[arg1] = arg2;
            }else if(option == 2){//구간 합
                bw.write(query(1,1,N,arg1,(int)arg2) + "\n");
            }
        }
        bw.close();
    }
    public static void init(int num, int start, int end){
        if(start==end){
            tree[num] = arr[start];
        }else{
            init(num*2, start, (start+end)/2);
            init(num*2 + 1,(start+end)/2 + 1, end);
            tree[num] = tree[num*2] + tree[num*2+1];
        }
    }
    public static long query(int num, int start, int end, int left, int right){
        if(right<start || left>end){//구하려는 구간내에 현재 범위가 없어.
            return 0;
        }else if(left<=start && right>=end){//구하려는 구간내에 현재 범위가 있어. 다 더해야겟지
            return tree[num];
        }
        long lsum = query(num*2, start, (start+end)/2, left, right);
        long rsum = query(num*2+1, (start+end)/2 + 1, end, left, right);
        return lsum + rsum;
    }
    public static void update(int num, int start, int end, int index, long diff){
        if(start>index || end<index) return; //현재 위치가 수정할 곳과 연관이 있는가?
        tree[num] += diff; // 있으니 변화량 반영

        if(start != end){//현재 위치가 리프노드인가? 그렇다면 이미 반영이 되었고 아니라면 재귀적으로 반영해야함.
            update(num*2, start,(start+end)/2,index,diff);
            update(num*2+1,(start+end)/2 + 1,end,index,diff);
        }
    }
}