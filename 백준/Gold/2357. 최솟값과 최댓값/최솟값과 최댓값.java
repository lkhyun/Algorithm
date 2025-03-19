import java.util.*;
import java.io.*;

class Node{
    long min;
    long max;
    Node(long min,long max){
        this.min = min;
        this.max = max;
    }
}
public class Main {
    static int N;
    static int M;
    static long[] arr;
    static Node[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N*4];
        tree = new Node[N*4];
        
        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            Node n = query(1,1,N,left,right);
            bw.write(n.min+" "+n.max+"\n");
        }
        bw.close();
    }
    public static void init(int cur, int start, int end){
        if(start == end){
            tree[cur] = new Node(arr[start],arr[start]);
            return;
        }

        init(cur*2,start,(start+end)/2);
        init(cur*2 + 1, (start+end)/2 + 1, end);
        tree[cur] = new Node(Math.min(tree[cur*2].min,tree[cur*2 + 1].min),
                             Math.max(tree[cur*2].max,tree[cur*2 + 1].max));
    }
    public static Node query(int cur, int start, int end, int left, int right){
        if(left>end || right<start) return null;
        if(left<=start && right>=end) return tree[cur];

        Node l = query(cur*2,start,(start+end)/2,left,right);
        Node r = query(cur*2+1,(start+end)/2 + 1, end,left,right);
        if(l==null)return r;
        else if(r==null) return l;
        else return new Node(Math.min(l.min,r.min),Math.max(l.max,r.max));
    }
}