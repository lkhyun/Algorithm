import java.io.*;
import java.util.*;
class Node{
    int sushi;
    Node next;
    public Node(int sushi, Node next) {
        this.sushi = sushi;
        this.next = next;
    }
    
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 접시 수
    static int D; // 초밥 가지 수
    static int K; // 연속해서 먹는 접시 수
    static int C; // 쿠폰 번호
    static int max = 0;
    

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Node head = new Node(Integer.parseInt(br.readLine()),null);
        Node end = head;
        for(int i=1;i<N;i++){
            end.next = new Node(Integer.parseInt(br.readLine()),null);
            end = end.next;
        }
        end.next = head;
        Node start = head;

        int[] kinds = new int[D+1];
        int flag = 0;
        int cnt = 0;
        for(int i=0;i<K;i++){ //k개 연속으로 고르게 조정
            end = end.next;
            if(kinds[end.sushi]==0) cnt++;
            kinds[end.sushi]++;
            if(end.sushi == C) flag++;
        }
        if(flag==0){ //쿠폰 번호가 k개 안에 없을때
            max = cnt+1;
        }else{ //있을때
            max = cnt;
        }

        do {
            if(kinds[start.sushi]==1) cnt--;
            if(start.sushi==C) flag--;
            kinds[start.sushi]--;
            start = start.next;

            end = end.next;
            if(kinds[end.sushi]==0) cnt++;
            if(end.sushi==C) flag++;
            kinds[end.sushi]++;
            if(flag==0){
                max = Math.max(max,cnt+1);
            }else{
                max = Math.max(max,cnt);
            }
        } while (head != start);

        bw.write(max+"");
       
        bw.close();
    }
    
}
