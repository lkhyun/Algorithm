import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //건물의 개수
        int G = Integer.parseInt(st.nextToken()); //가희가 볼 수 있는 건물의 개수
        int D = Integer.parseInt(st.nextToken()); //단비가 볼 수 있는 건물의 개수
        List<Integer> l = new LinkedList<>();
        int diff = (N+1) - (G+D);
        if(diff<0){//그려보니까 이 조건이 상한임.
            bw.write("-1");
        }else{
            for(int i=0;i<diff;i++){
                l.add(1);
            }
            if(G>=D){
                for(int i=1;i<=G;i++){
                    l.add(i);
                }
                for(int i=D-1;i>=1;i--){
                    l.add(i);
                }
            }else{
                if(G==1){
                    l.add(0,D);
                    for(int i=D-1;i>=1;i--){
                        l.add(i);
                    }
                }else{
                    for(int i=1;i<=G-1;i++){
                        l.add(i);
                    }
                    for(int i=D;i>=1;i--){
                        l.add(i);
                    } 
                }
                
            }
            for(int i: l){
                bw.write(i+" ");
            }
        }
        bw.flush();
    }
}