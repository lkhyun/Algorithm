import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = 8;
        int aflag = 0;
        int dflag = 0;
        for(int a=1;a<=8;a++,d--){
            int cur = Integer.parseInt(st.nextToken());
            if(cur!=a){ aflag=1; }
            if(cur!=d){ dflag=1; }
        }
        if(aflag==0){bw.write("ascending");}
        else if(dflag==0){bw.write("descending");}
        else{bw.write("mixed");}

        bw.flush();
    }
}
