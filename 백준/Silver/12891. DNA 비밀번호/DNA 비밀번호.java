import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int P;
    static int[] condition = new int[4]; // A,C,G,T 순서
    static int[] cur = new int[4];
    static int count = 0;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            condition[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i=0;i<=S-P;i++){
            if(i==0){
                for(int j=0;j<P;j++){
                    update(DNA.charAt(j), 0);
                }
            }else{
                update(DNA.charAt(i+P-1), 0);
                update(DNA.charAt(i-1),1);
            }
            boolean flag = true;
            for(int j=0;j<4;j++){
                if(cur[j]<condition[j]){
                    flag = false;
                }
            }
            if(flag){
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
    }
    public static void update(char c, int opt){
        if(opt==0){//추가
            if(c == 'A'){
                cur[0]++;
            }else if(c == 'C'){
                cur[1]++;
            }else if(c == 'G'){
                cur[2]++;
            }else if(c == 'T'){
                cur[3]++;
            }
        }else{//제거
            if(c == 'A'){
                cur[0]--;
            }else if(c == 'C'){
                cur[1]--;
            }else if(c == 'G'){
                cur[2]--;
            }else if(c == 'T'){
                cur[3]--;
            }
        }
    }

}