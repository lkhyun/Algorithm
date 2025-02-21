import java.util.*;
import java.io.*;

class Node {
    int parent;
    int left;
    int right;

    Node(int parent, int left, int right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return String.valueOf(this.parent +"|"+ this.left +"|"+ this.right);
    }
}

public class Solution {
    static Node[] tree;
    static int count;

    public static void main(String[] args) throws Exception{
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            tree = new Node[V+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= E; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if(tree[start] == null){tree[start] = new Node(0,0,0);}
                if(tree[end]==null){tree[end] = new Node(0,0,0);}
                if(tree[start].left==0){
                    tree[start].left = end;
                }else{
                    tree[start].right = end;
                }
                tree[end].parent = start;
            }
            int commonRoot = findCommonParent(A, B);
            count = 0;
            countChild(commonRoot);
            bw.write("#"+t+" "+commonRoot+" "+count+"\n");
        }
        
        bw.flush();
    }

    public static int findDepth(int a) {
        int aParent = a;
        int cnt = 0;
        while (aParent != 1) {
            aParent = tree[aParent].parent;
            cnt++;
        }
        return cnt;
    }

    public static int findCommonParent(int a, int b) {
        int aParent = a;
        int bParent = b;
        int aDepth = findDepth(a);
        int bDepth = findDepth(b);
        int depthDiff = aDepth - bDepth;
        if (depthDiff < 0) {
            for (int i = 0; i < Math.abs(depthDiff); i++) {
                bParent = tree[bParent].parent;
            }
        } else if (depthDiff > 0) {
            for (int i = 0; i < Math.abs(depthDiff); i++) {
                aParent = tree[aParent].parent;
            }
        }
        while (aParent != bParent) {
            aParent = tree[aParent].parent;
            bParent = tree[bParent].parent;
        }
        return aParent;
    }

    public static void countChild(int root) {
        count++;
        if (tree[root].left != 0) {
            countChild(tree[root].left);
        }
        if (tree[root].right != 0) {
            countChild(tree[root].right);
        }
    }
}