import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Map<Integer,String> intToStr = new HashMap<>();
        Map<String,Integer> strToInt = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            intToStr.put(i,str);
            strToInt.put(str,i);
        }

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            int number;
            try{
                number = Integer.parseInt(str);
                bw.write(intToStr.get(number)+"\n");
            }catch(NumberFormatException e){
                int answer = strToInt.get(str);
                bw.write(answer+"\n");
            }
        }

        bw.close();
    }
}
