import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static Map<String,String[]> adjList;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        adjList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = new String[2];
            String cur = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            temp[0] = left;
            temp[1] = right;
            adjList.put(cur,temp);
        }
        preOrder("A");
        bw.write("\n");
        inOrder("A");
        bw.write("\n");
        postOrder("A");
        bw.close();
    }
    public static void preOrder(String cur) throws Exception {
        String[] temp = adjList.get(cur);
        bw.write(cur);
        if(!temp[0].equals(".")){
            preOrder(temp[0]);
        }
        if(!temp[1].equals(".")){
            preOrder(temp[1]);
        }
    }
    public static void inOrder(String cur) throws Exception{
        String[] temp = adjList.get(cur);
        if(!temp[0].equals(".")){
            inOrder(temp[0]);
        }
        bw.write(cur);
        if(!temp[1].equals(".")){
            inOrder(temp[1]);
        }
    }
    public static void postOrder(String cur) throws Exception{
        String[] temp = adjList.get(cur);
        if(!temp[0].equals(".")){
            postOrder(temp[0]);
        }
        if(!temp[1].equals(".")){
            postOrder(temp[1]);
        }
        bw.write(cur);
    }
}
