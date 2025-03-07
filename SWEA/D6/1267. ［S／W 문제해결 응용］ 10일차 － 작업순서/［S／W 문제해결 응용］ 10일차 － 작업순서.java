import java.util.*;
import java.io.*;

class Node{
    int vertex;
    Node next;

    Node(int vertex, Node next){
        this.vertex = vertex;
        this.next = next;
    }
}

public class Solution{
    static int V;
    static int E;
    static Node[] adjList;
    static int[] degree;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        for(int t = 1;t<=10;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new Node[V+1];
            degree = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<E;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
                degree[to]++;
            }
            bw.write("#"+t+" ");
            topology(bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void topology(BufferedWriter bw) throws Exception{
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1;i<=V;i++){//진입차수 0인거 넣기
            if(degree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curVertex = q.poll();
            bw.write(curVertex+" ");
            for(Node n = adjList[curVertex]; n != null; n = n.next){
                if(--degree[n.vertex] == 0){
                    q.add(n.vertex);
                }
            }
        }
    }
}