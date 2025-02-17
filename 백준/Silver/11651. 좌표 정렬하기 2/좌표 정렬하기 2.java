import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int i;
    int j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public int compareTo(Node o){
        if(this.j==o.j){
            return this.i - o.i;
        }else{
            return this.j-o.j;
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Node> l = new ArrayList<>(N);
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(l);
        for(Node n : l){
            bw.write(n.i + " " + n.j + "\n");
        }
        bw.flush();
    }
}