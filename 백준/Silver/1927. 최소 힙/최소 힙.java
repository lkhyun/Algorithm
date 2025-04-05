import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(minheap.isEmpty()) bw.write("0\n");
                else bw.write(minheap.poll()+"\n");
            }else{
                minheap.add(temp);
            }
        }
        bw.close();
    }

}
