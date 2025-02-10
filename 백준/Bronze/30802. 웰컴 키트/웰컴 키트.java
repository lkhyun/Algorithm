import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //총 인원

        int[] sizes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine()); //tshirt 정보
        for(int i=0;i<6;i++){
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); //묶음 정보
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int tShirts = 0;
        int pens = 0;
        for(int i=0;i<6;i++){
            tShirts += sizes[i]/T;
            if(sizes[i]%T != 0){
                tShirts++;
            }
        }
        bw.write(tShirts+"\n");
        bw.write(N/P+" "+N%P);
        
        bw.flush();
    }
}
