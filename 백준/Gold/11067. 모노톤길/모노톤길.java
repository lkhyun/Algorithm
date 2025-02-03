import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            Map<Integer,PriorityQueue<Integer>> cafes = new TreeMap<>();
            for(int n = 0;n<N;n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> cafe = cafes.getOrDefault(key,new PriorityQueue<>());
                cafe.offer(value);
                cafes.put(key,cafe);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            Map<Integer,Point> cafenumbers = new HashMap<>();
            int prev = 0;
            int currentnumber = 0;
            for(Integer i : cafes.keySet()){
                PriorityQueue<Integer> cafe = cafes.get(i);
                if(cafe.peek() == prev){
                    int j = 1;
                    int temp = cafe.size();
                    while(!cafe.isEmpty()){
                        if(cafe.size()==1){prev = cafe.peek();}
                        cafenumbers.put(currentnumber+j,new Point(i,cafe.poll()));
                        j++;
                    }
                    currentnumber += temp;
                }
                else{
                    int j = cafe.size();
                    int temp = cafe.size();
                    prev = cafe.peek();
                    while(!cafe.isEmpty()){
                        cafenumbers.put(currentnumber+j,new Point(i,cafe.poll()));
                        j--;
                    }
                    currentnumber += temp;
                }
            }
            for(int m=0;m<M;m++){
                Point temp = cafenumbers.get(Integer.parseInt(st.nextToken()));
                bw.write(temp.x + " " + temp.y +"\n");
            }
        }
        bw.flush();
    }

}
