import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception{
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<K;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                stk.poll();
            }else{
                stk.push(temp);
            }
        }
        int sum = 0;
        while(!stk.isEmpty()){
            sum += stk.poll();
        }
        bw.write(sum+"");
        bw.flush();
    }
}