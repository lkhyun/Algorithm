import java.io.*;
import java.util.*;
class Node implements Comparable<Node>{
    int age;
    String name;
    int order;
    Node(int age,String name, int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }
    @Override
    public int compareTo(Node o){
        if(this.age<o.age){
            return -1;
        }else if(this.age>o.age){
            return 1;
        }else{
            if(this.order < o.order){
                return -1;
            }else{
                return 1;
            }
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
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            l.add(new Node(age,name,i));
        }
        Collections.sort(l);
        for(Node n : l){
            bw.write(n.age + " " + n.name + "\n");
        }
        bw.flush();
    }
}
