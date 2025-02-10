import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int curTotal = 0;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    curTotal = cards[i]+cards[j]+cards[k];
                    if(curTotal<=M){
                        max = Math.max(curTotal,max);
                    }
                    curTotal = 0;
                }
            }
        }

        bw.write(max+"");
        bw.flush();
    }
}
